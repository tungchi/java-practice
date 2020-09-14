package com.ykfa.jdk8;

/**
 * @author yingkefa
 * @date 2020年08月06日10:17:29
 */
public class TestDefaultInterfaceImpl implements TestDefaultInterface ,TestDefaultParentInterface{

    public static void main(String[] args) {
        TestDefaultInterface testDefaultInterface = new TestDefaultInterfaceImpl();
        TestDefaultInterfaceImpl.update();
//        testDefaultInterface.output();
//        testDefaultInterface.version();
        testDefaultInterface.doOutput();
//        TestDefaultInterface.update();
    }

    static void update(){
        TestDefaultInterface.update();
    }

    @Override
    public void doOutput() {
        TestDefaultInterface.super.version();
        TestDefaultInterface.super.output();
        TestDefaultInterface.update();
    }
}
