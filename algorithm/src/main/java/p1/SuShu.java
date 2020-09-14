package p1;

import sun.java2d.pipe.SpanIterator;

public class SuShu {
    public static void main(String[] args) {
        System.out.println("3-100之间的素数有:");
        boolean isPrime;
        int iCount = 0;
        for(int i=3;i<=100;i++){
            isPrime = true;
            for(int j=2;j<=i/2;j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.print(i+"\t");
                iCount++;
                if(iCount%6==0){
                    System.out.println();
                }
            }
        }
    }
}
