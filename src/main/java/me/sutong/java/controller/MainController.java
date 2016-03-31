package me.sutong.java.controller;

import com.alibaba.fastjson.JSON;
import me.sutong.java.po.User;
import me.sutong.java.mapper.dev.UserMapper;
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
    @Autowired
    UserMapper test2Mapper;

    @RequestMapping("/hello")
    public String b(Model model){
        model.addAttribute("message", "Hello World!");
        return "hello";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(Model model){
        return "test succeed";
    }

    @RequestMapping("/a")
    @ResponseBody
    public String h(){
        User test = test2Mapper.select(1);

        return JSON.toJSONString(test);
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(){
        return String.valueOf(test2Mapper.insert(new User("test")));
    }

    @RequestMapping("getall")
    @ResponseBody
    public String getall(){
        return JSON.toJSONString(test2Mapper.getAll());
    }

    @RequestMapping("json")
    @ResponseBody
    public ResponseEntity<User> getjson(){
        User user = new User();
        user.setName("name");
        user.setId(123l);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
