package com.ream.www.maventest.controller;

import com.alibaba.fastjson.JSON;
import com.ream.www.maventest.Test2;
import com.ream.www.maventest.map.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tong on 12/11/15.
 */
@Controller
public class MainController {
    @Autowired Test2Mapper test2Mapper;

    @RequestMapping("/a")
    @ResponseBody
    public String h(){
        Test2 test = test2Mapper.selectTest(1);

        return JSON.toJSONString(test);
    }
}
