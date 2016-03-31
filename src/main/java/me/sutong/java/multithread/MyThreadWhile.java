package me.sutong.java.multithread;

/**
 * Created by tong on 1/28/16.
 */
public class MyThreadWhile implements Runnable {

    private String name;


    public MyThreadWhile(String name){
        this.name = name;
        System.out.println("create " + name);
    }

    public void run() {
        while(true) {
            System.out.println("running " + this.name);
        }
    }
}
