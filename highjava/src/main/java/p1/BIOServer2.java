package p1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer2 {
    static class SocketProcess implements Runnable{
        Socket s;
        public SocketProcess(Socket s){
            this.s = s;
        }
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        int port = 9010;
        try(ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                Socket s = ss.accept();
                new Thread(new SocketProcess(s)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
