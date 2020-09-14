package course.one.c1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: ykfa
 * @Date: 2019/5/21 15:15
 * 改进的
 */
public class ZkDistributeImproveLock implements Lock {
    public static String FILE_SEPARATOR = "/";
    private String lockPath;
    private ZkClient client;
    private String currentPath;
    private String beforePath;

    /**
     *
     * @param lockPath 锁的路径
     */
    public ZkDistributeImproveLock(String lockPath){
        super();
        this.lockPath = lockPath;
        client = new ZkClient("192.168.137.168:2181");
        client.setZkSerializer(new MyZkSerializer());

        if(!this.client.exists(lockPath)){
            try{
                this.client.createPersistent(lockPath);
            }catch (ZkNodeExistsException e){

            }
        }
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
                System.out.println("---监听到节点被删除");
                //减一
                cdl.countDown();
            }
        };

        //注册watch
        client.subscribeDataChanges(this.beforePath,listener);

        //阻塞自己
        if(this.client.exists(this.beforePath)){
            try {
                cdl.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //取消注册
        client.unsubscribeDataChanges(this.beforePath,listener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if(this.currentPath == null){
            //创建临时顺序节点
            currentPath = this.client.createEphemeralSequential(lockPath + FILE_SEPARATOR,"aaa");
        }

        //获得所有的子节点
        List<String> children = this.client.getChildren(lockPath);

        //排序list
        Collections.sort(children);

        //判断当前节点是否是最小的
        if(currentPath.equals(lockPath + FILE_SEPARATOR + children.get(0))){
            return true;
        } else {
            //取得前一个
            //得到字节的索引号
            int curIndex = children.indexOf(currentPath.substring(lockPath.length() + 1));
            beforePath = lockPath + FILE_SEPARATOR + children.get(curIndex -1);
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        client.delete(this.currentPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
