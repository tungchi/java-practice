package com.ykfa.jdk8;

/**
 * @author yingkefa
 * @date 2020年08月06日11:09:44
 */
public interface TestDefaultParentInterface {
    default void version(){
        System.out.println("版本0.0.0");
    }
    default void output(){
        System.out.println("接口的父类输出");
    }
}
