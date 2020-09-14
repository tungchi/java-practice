package com.runlion.learn.lession2;

// 以下代码来源于【参考1】
class VolatileExample {
  int x = 0;
  volatile boolean v = false;
  public void writer(int x) {
    this.x = x;
    v = true;
    System.out.println(Thread.currentThread().getName()+"写值:"+x);
  }
  public void reader() {
    if (v) {
      System.out.println(Thread.currentThread().getName()+"读值:"+x);
    }
  }

  public static void main(String[] args) {
    VolatileExample example = new VolatileExample();
    for(int i=0;i<10;i++){
      int finalI = i;
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          example.writer(finalI *10);
          example.reader();
        }
      });
      thread.setName("线程"+finalI+":");
      thread.start();
    }
  }
}