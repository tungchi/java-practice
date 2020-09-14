package course.one.c1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单号生成器
 * @Author: ykfa
 * @Date: 2019/5/15 11:49
 */
public class OrderCodeGenerator {
    //自增长序列
    private int i = 0;
    public String getOrderCode(){
        Date now = new Date();
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
        return  sdf.format(now) + ++i;
    }

    public static void main(String[] args) {
        OrderCodeGenerator ong = new OrderCodeGenerator();
        for(int i=0;i<10;i++){
            System.out.println(ong.getOrderCode());
        }
    }
}
