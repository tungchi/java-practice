package p1;

public class StuEnum {
    final static int MIN = 280;
    final static int MAX = 320;
    final static double JYL = 83.23/100;
    public static void main(String[] args) {
        int sum ;//总人数
        int jy ;//就业人数
        int real_sum =0;
        int real_jy =0;
        double jyl = 0;
        for(sum=MIN;sum<=MAX;sum++){
            jy = (int)(sum*JYL);
            if(Math.abs((float)jy/sum-JYL)<Math.abs(jyl-JYL)){
                real_jy = jy;
                real_sum = sum;
                jyl = real_jy/real_sum;
            }
        }
        System.out.println("最有可能的总人数:"+real_sum+",就业人数:"+real_jy);
    }
}
