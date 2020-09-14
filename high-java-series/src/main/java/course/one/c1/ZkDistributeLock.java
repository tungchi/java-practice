package course.one.c1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: ykfa
 * @Date: 2019/5/21 15:15
 */
public class ZkDistributeLock implements Lock {

    private String lockPath;
    private ZkClient client;

    /**
     *
     * @param lockPath 锁的路径
     */
    public  ZkDistributeLock(String lockPath){
        super();
        this.lockPath = lockPath;
        client = new ZkClient("192.168.137.168:2181");
        client.setZkSerializer(new MyZkSerializer());
    }

    @Override
    public void lock() {
        //如果获取不到锁, 阻塞等待
        if(!tryLock()){
            //没有获得锁,阻塞自己
            waitForLock();
            //再次尝试获得锁,注意,这里递归
            lock();
        }
    }

    private void waitForLock() {

        //阻塞,倒计数锁,如果值减为0,所有锁住的线程都会被唤醒
        CountDownLatch cdl = new CountDownLatch(1);

        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("---节点被删除-----");
                //减一
                cdl.countDown();
            }
        };

        //注册watch
        client.subscribeDataChanges(lockPath,listener);

        //阻塞自己
        if(this.client.exists(lockPath)){
            try {
                cdl.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //取消注册
        client.unsubscribeDataChanges(lockPath,listener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        //创建临时节点
        try {
            client.createEphemeral(lockPath);
        }catch (ZkNodeExistsException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        client.delete(lockPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
