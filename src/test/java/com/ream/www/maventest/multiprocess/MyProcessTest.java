package com.ream.www.maventest.multiprocess;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by tong on 1/25/16.
 */
public class MyProcessTest extends TestCase {

    public void test(){
        final ProcessBuilder pb = new ProcessBuilder("ls", "-a", "-l");

        System.out.println(Paths.get("").toAbsolutePath().toString());

        pb.redirectOutput(new File("test"));

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}