package com.ream.www.maventest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tong on 12/11/15.
 */
@Controller
public class MainController {
    @RequestMapping("/a")
    @ResponseBody
    public String h(){
        return "test";
    }
}
