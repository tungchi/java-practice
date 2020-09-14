package course.one.c1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 模拟高并发
 * @Author: ykfa
 * @Date: 2019/5/15 15:48
 */
public class ConcurrentTestDistributeDemo {
    public static void main(String[] args) {
        //并发数
        int currency = 50;
        //循环屏障,让20个线程在跑...
        CyclicBarrier cb = new CyclicBarrier(currency);

        // 多线程模拟高并发
        for (int i = 0;i < currency; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OrderService orderService = new OrderServiceImplWithDisLock();
                    System.out.println(Thread.currentThread().getName()+"------我准备好-------");
                    //等待一起出发
                    try {
                        cb.await();
                    }catch (InterruptedException | BrokenBarrierException e){
                        e.printStackTrace();
                    }
                    //调用创建订单服务
                    orderService.createOrder();
                }
            }).start();
        }
    }
}
