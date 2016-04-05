package me.sutong.java.controller;

import com.alibaba.fastjson.JSON;
import me.sutong.java.po.User;
import me.sutong.java.mapper.dev.UserMapper;
import me.sutong.java.vo.RequestObjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tong on 12/11/15.
 */
@Controller("mainController")
public class MainController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test succeed";
    }

    @RequestMapping("/select")
    @ResponseBody
    public String select(@RequestParam Long id) {
        User test = userMapper.select(id);
        return JSON.toJSONString(test);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(@RequestParam String name) {
        User user = new User(name);
        Long ret = userMapper.insert(user);

        return String.format("ret: %d, user: %s", ret, JSON.toJSONString(user));
    }

    @RequestMapping("/get_all")
    @ResponseBody
    public String getAll() {
        return JSON.toJSONString(userMapper.getAll());
    }

    @RequestMapping("/request_object")
    @ResponseBody
    public RequestObjectVO requestObject(RequestObjectVO requestObjectVO){
        return requestObjectVO;
    }

}
