package course.one.c1;

import java.util.concurrent.locks.Lock;

/**
 * @Author: ykfa
 * @Date: 2019/5/21 15:29
 */
public class OrderServiceImplWithDisLock implements OrderService {

    //用statis修饰来模拟共用一个订单编号服务
    private static OrderCodeGenerator ocg = new OrderCodeGenerator();

    /**
     *  创建订单接口
     */
    @Override
    public void createOrder() {
        String orderCode = null ;
        //分布式锁
        Lock lock = new ZkDistributeImproveLock("/study666");
//        Lock lock = new ZkDistributeLock("/study666");
        try {
            lock.lock();
            //获取订单号
            orderCode = ocg.getOrderCode();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + "=====>" + orderCode);
    }
}
