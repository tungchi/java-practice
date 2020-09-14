package com.runlion.learn.lesson3;

import java.util.Arrays;
import java.util.concurrent.*;

class SafeCalc {
  long value = 0L;
  long get() {
    return value;
  }
  synchronized void addOne() {
    value += 1;
  }

    public static void main(String[] args) throws InterruptedException {
      CountDownLatch countDownLatch = new CountDownLatch(1000);
      SafeCalc safeCalc = new SafeCalc();
      Executor executor = new ThreadPoolExecutor(1, 10,
              30, TimeUnit.MINUTES,
              new ArrayBlockingQueue<>(10),
              new SafeCalcThreadFactory(),
             new ThreadPoolExecutor.CallerRunsPolicy());
      for(int i=0;i<100;i++){
          executor.execute(() -> {
              safeCalc.addOne();
              countDownLatch.countDown();
          });
      }
        countDownLatch.await(30,TimeUnit.SECONDS);
        System.out.println("最后结果:"+safeCalc.get());

  }




  public static void output(String[] args){
    StringBuilder sb = new StringBuilder();
    Arrays.stream(args).forEach(sb::append);
    System.out.println(sb);
  }
}

class SafeCalcThreadFactory implements ThreadFactory {

    public SafeCalcThreadFactory(){
        super();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("testSafeCalc");
        return thread;
    }
}