package p1;

import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;

import java.util.Random;
import java.util.Scanner;

public class P1_1 {
    static int N = 20;

    public static void main(String[] args) {
        int[] arr = new int[N];
        int x,n,i;
        int f = -1;
        Random random = new Random();
        for(i=0;i<N;i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println("生成的随机序列:");
        for(i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("输入要查找的整数:");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        for(i=0;i<N;i++){
            if(x==arr[i]){
                f = i;
                break;
            }
        }
        if(f<0){
            System.out.println("没找到数据:"+x);
        }else{
            System.out.println("数据:"+x+"位于数组的第"+(f+1)+"个元素处.");
        }
    }
}
