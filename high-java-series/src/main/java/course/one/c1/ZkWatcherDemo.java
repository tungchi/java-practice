package course.one.c1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.I0Itec.zkclient.serialize.ZkSerializer;

/**
 * @Author: ykfa
 * @Date: 2019/5/20 16:19
 * watch监听实例
 */
public class ZkWatcherDemo {
    public static void main(String[] args) throws Exception{
        //创建一个zk客户端
        ZkClient client = new ZkClient("192.168.137.168:2181");
//        ZkClient client = new ZkClient("127.0.0.1:2181",5);
        client.setZkSerializer(new MyZkSerializer());
        client.subscribeDataChanges("/mike/a", new IZkDataListener() {
            /**
             * @param s dataPath
             * @param o data
             * @throws Exception
             */
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("----收到节点变化"+o+"-----");
            }
            /**
             * @param s dataPath
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("收到节点被删除了-----");
            }
        });
        client.delete("/mike/c1");
        try{
            Thread.sleep(1000 * 60 * 2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
