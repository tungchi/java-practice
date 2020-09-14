package com.ykfa.jdk8;

/**
 * @author yingkefa
 * @date 2020年08月06日10:15:31
 */
public interface TestDefaultInterface extends TestDefaultParentInterface{
    @Override
    default void output(){
        System.out.println("jdk接口可以实现方法了?");
    }

    @Override
    default void version(){
        System.out.println("版本1.0.0");
    }

    static void update(){
        System.out.println("升级到1.0.1");
    }

    void doOutput();
}
