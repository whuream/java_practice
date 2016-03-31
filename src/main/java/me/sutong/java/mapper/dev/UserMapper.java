package me.sutong.java.mapper.dev;

import me.sutong.java.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tong on 12/8/15.
 */
public interface UserMapper {
    User select(@Param("id") Long id);

    List<User> getAll();

    Long insert(@Param("user") User user);


}
