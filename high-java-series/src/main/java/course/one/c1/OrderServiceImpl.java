package course.one.c1;

/**
 * @Author: ykfa
 * @Date: 2019/5/15 15:21
 */
public class OrderServiceImpl implements OrderService {
    private OrderCodeGenerator ocg = new OrderCodeGenerator();

    /**
     * 创建订单接口
     */
    @Override
    public void createOrder() {
        String orderCode = ocg.getOrderCode();
        System.out.println(Thread.currentThread().getName()+" ********" + orderCode);

        //业务代码
    }
}
