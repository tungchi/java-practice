package p1;

public class ShowAscii {
    public static void main(String[] args) {
        int j = 0;
        for(int i=32;i<=126;i++){
            String temp = i<100?"0"+i:""+i;
            if(j<8){
                System.out.print(temp+"的字符是"+(char)i+" ");
                j++;
            }else{
                System.out.println(temp+"的字符是"+(char)i+" ");
                j=0;
            }
        }
    }
}
