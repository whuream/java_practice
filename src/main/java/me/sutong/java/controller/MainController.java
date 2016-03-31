package me.sutong.java.controller;

import com.alibaba.fastjson.JSON;
import me.sutong.java.po.Test2;
import me.sutong.java.mapper.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tong on 12/11/15.
 */
@Controller("mainController")
public class MainController {
    @Autowired Test2Mapper test2Mapper;

    @RequestMapping("/a")
    @ResponseBody
    public String h(){
        Test2 test = test2Mapper.selectTest(1);

        return JSON.toJSONString(test);
    }

    @RequestMapping("/b")
    public String b(Model model){
        model.addAttribute("message", "Hello World!");
        return "hello";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(Model model){
        return "test succeed";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(){
        return String.valueOf(test2Mapper.insertOne(new Test2("test")));
    }

    @RequestMapping("getall")
    @ResponseBody
    public String getall(){
        return JSON.toJSONString(test2Mapper.getAll());
    }

    @RequestMapping("json")
    @ResponseBody
    public ResponseEntity<Test2> getjson(){
        Test2 test2 = new Test2();
        test2.setName("name");
        test2.setId(123l);
        return new ResponseEntity<Test2>(test2, HttpStatus.OK);
    }
}
