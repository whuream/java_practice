package com.ream.www.maventest.mapper;

import com.ream.www.maventest.po.Test2;

import java.util.List;

/**
 * Created by tong on 12/8/15.
 */
public interface Test2Mapper {
    Test2 selectTest(Integer id);

    List<Test2> getAll();

    Long insertOne(Test2 test2);


}
