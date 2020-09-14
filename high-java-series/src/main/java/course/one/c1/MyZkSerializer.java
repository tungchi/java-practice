package course.one.c1;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * @Author: ykfa
 * @Date: 2019/5/20 16:25
 */
public class MyZkSerializer implements ZkSerializer {
    String charset = "UTF-8";

    /**
     * 序列化
     * @param o
     * @return
     * @throws ZkMarshallingError
     */
    @Override
    public byte[] serialize(Object o) throws ZkMarshallingError {
        try {
            return String.valueOf(o).getBytes(charset);
        }catch (UnsupportedEncodingException e){
            throw new ZkMarshallingError(e);
        }
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     * @throws ZkMarshallingError
     */
    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        try {
            return new String(bytes,charset);
        }catch (UnsupportedEncodingException e){
            throw  new ZkMarshallingError(e);
        }
    }
}
