package com.ykfa.map.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingkefa
 * @date 2020年08月03日10:35:56
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap(4,0.75f);
        for(int i=0;i<16;i++){
            map.put(""+i,i);
        }
        Map newMap = new HashMap<>(map);
        System.out.println(tableSizeFor(3));
    }
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
