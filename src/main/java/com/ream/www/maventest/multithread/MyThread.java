package com.ream.www.maventest.multithread;

/**
 * Created by tong on 1/25/16.
 */
public class MyThread implements Runnable {
    private String name;


    public MyThread(String name){
        this.name = name;
        System.out.println("create " + name);
    }

    public void run() {
        while(true) {
            System.out.println("running " + this.name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
