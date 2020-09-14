package course.one.c1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ykfa
 * @date : 2019/5/15 15:41
 */
public class OrderServiceImplWithLock implements OrderService {

//    private OrderCodeGenerator org = new OrderCodeGenerator();

    private static OrderCodeGenerator org = new OrderCodeGenerator();

    private static Lock lock = new ReentrantLock();
    /**
     * 创建订单接口
     */
    @Override
    public void createOrder() {
        String orderCode = null;
        try{
            lock.lock();
            //获取订单号
            orderCode = org.getOrderCode();
        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " =======>" +orderCode);
    }

}
