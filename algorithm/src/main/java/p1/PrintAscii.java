package p1;


public class PrintAscii {
    public void printAscii(char ch){
        int ascii = (int)ch;
        System.out.println(ch+"的Ascii码是:"+ ascii);
    }

    public static void main(String[] args) {
        PrintAscii printAscii = new PrintAscii();
        printAscii.printAscii('k');
        printAscii.printAscii('O');
    }
}
