package me.sutong.java.mapper.dev;

import com.alibaba.fastjson.JSON;
import me.sutong.java.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tong on 3/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring-beans.xml"})
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void testSelect() throws Exception {
        User user = new User("test select");

        userMapper.insert(user);

        System.out.println(JSON.toJSONString(userMapper.select(user.getId())));


    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println(JSON.toJSONString(userMapper.getAll()));
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println(userMapper.insert(new User("name")));
    }
}