package me.sutong.java.mapper.dev;

import me.sutong.java.transaction.TransactionTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tong on 3/31/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class TransactionTest {

    @Resource
    private TransactionTarget transactionTarget;

//    @Test
    public void test(){
        try {
            // transaction succeed
            // the mysql db must be a innodb
            // CREATE TABLE `user` (
            // `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
            // `name` varchar(100) DEFAULT NULL,
            // PRIMARY KEY (`id`))
            // ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
            System.out.println(transactionTarget.insert("transaction test"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
