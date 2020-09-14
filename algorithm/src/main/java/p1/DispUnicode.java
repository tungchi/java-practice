package p1;

public class DispUnicode {
    public void queryCoding(String arg){
        System.out.print("用户传递的字符串是:");
        System.out.println(arg);
        System.out.print("计算得到的汉字Unicode编号是:");
        for(int i=0;i<arg.length();i++){
            char ch = arg.charAt(i);
            if(ch<19968||ch>40869){
                continue;
            }else{
                System.out.print((int)ch+" ");
            }
        }
    }

    public static void main(String[] args) {
        DispUnicode obj = new DispUnicode();
        obj.queryCoding("和谐万岁");
    }
}
