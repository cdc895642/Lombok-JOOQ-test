package com.site.jooqtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import org.junit.Ignore;
import org.junit.Test;

public class StreamTest3 {

//  @Ignore
  //100000 - 3100
  //1 000 000 - 27000 ] task2 - 190
  //task3 - 10000 - 4100
  @Test
  public  void testParallelStream(){
    List<String> list=new ArrayList<>();
    for (int i=0;i<10_000;i++){
      list.add("value "+i);
    }
    long start=System.currentTimeMillis();
    list.parallelStream().forEach(this::task3);
    long end=System.currentTimeMillis();
    System.out.println(end-start);
  }

  //100000 - 2900
  //1000000 - 28000 | tas2 - 180
  //task3 - 10000 - 4300
  @Test
  public  void testParallelStreamFork() throws ExecutionException, InterruptedException {
    ForkJoinPool pool=new ForkJoinPool();
    List<String> list=new ArrayList<>();
    for (int i=0;i<10_000;i++){
      list.add("value "+i);
    }
    long start=System.currentTimeMillis();
    pool.submit(()->list.parallelStream().forEach(this::task3)).get();
    long end=System.currentTimeMillis();
    System.out.println(end-start);
  }

  //100000 - 2600
  //1000000 - 22000 | task2 - 138
  //task3- 10000 - 16000
  @Test
  public  void testNoParallelStream() throws ExecutionException, InterruptedException {
    List<String> list=new ArrayList<>();
    for (int i=0;i<10000;i++){
      list.add("value "+i);
    }
    long start=System.currentTimeMillis();
    list.forEach(this::task3);
    long end=System.currentTimeMillis();
    System.out.println(end-start);
  }

  public void task1(String s){
    System.out.println(s+" - "+Thread.currentThread().getName());
  }

  public void task2(String s){
    int sunm=0;
    for (int i=0;i<1000000;i++){
      sunm+=i;
    }
  }

  public void task3(String s){
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
