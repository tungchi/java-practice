package com.ykfa.c2;

/**
 * @author yingkefa
 * @date 2020年07月27日15:22:06
 */
public class MyArray {

    public static void main(String[] args) {
        /*int[] array = new int[10];
        for(int i=0;i<5;i++){
            array[i] = i;
        }*/
        MyArray myArray = new MyArray(10);
        for (int i=0;i<10;i++){
            myArray.insert(10-i,i);
        }
        myArray.output();
    }

    private int[] array;
    private int size;
    int maxSize ;

    public MyArray(int capacity){
        this.array = new int[capacity];
        this.maxSize = capacity;
        size = 0 ;
    }

    /**
     * 数组插入元素
     * @param element 插入的元素
     * @param index 插入的位置
     */
    public void insert(int element,int index){
        //判断访问下标是否超出范围
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围!");
        }
        if(size>=maxSize){
            throw new IndexOutOfBoundsException("元素已满!");
        }
        //从右向左循环,将元素逐个向右挪1位
        for (int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 输出数组
     */
    public void output(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : array) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length()-1).append("]");
        System.out.println(sb);
    }


}
