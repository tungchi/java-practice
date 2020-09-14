package p1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class BIOClient implements Runnable {
    private String host;
    private int port;
    private Charset charset = Charset.forName("utf-8");

    public BIOClient(String host,int port){
        super();
        this.host = host;
        this.port = port;
    }

    public void run() {
        try(Socket s = new Socket(host,port); OutputStream out = s.getOutputStream()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入:");
            String message = scanner.nextLine();
            out.write(message.getBytes(charset.name()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BIOClient client = new BIOClient("localhost",9010);
        client.run();
    }
}
