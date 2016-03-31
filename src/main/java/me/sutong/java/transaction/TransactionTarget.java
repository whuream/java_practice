package me.sutong.java.transaction;

import com.alibaba.fastjson.JSON;
import me.sutong.java.mapper.dev.UserMapper;
import me.sutong.java.po.User;
import me.sutong.java.tools.DbRetCheck;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by tong on 3/31/16.
 */
@Component("transactionTarget")
public class TransactionTarget {
    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public Long insert(String name){
        User user = new User(name);
        Long ret = userMapper.insert(user);

        System.out.println(JSON.toJSONString(user));

        DbRetCheck.dbRetException(ret, 0l, DbRetCheck.CompareTypeEnum.EQUAL);

        return ret;
    }
}
