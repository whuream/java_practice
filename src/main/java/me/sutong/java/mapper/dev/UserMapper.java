package me.sutong.java.mapper.dev;

import me.sutong.java.po.User;

import java.util.List;

/**
 * Created by tong on 12/8/15.
 */
public interface UserMapper {
    User select(Long id);

    List<User> getAll();

    Long insert(User user);


}
