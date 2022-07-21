package cn.kollorsong.controller;

import cn.kollorsong.pojo.Users;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RestController
@RequestMapping("/test")
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        log.info("这里是info信息");
        log.debug("这里是debug信息");
        log.trace("这里是trace信息");
        log.warn("这里是warn信息");
        log.error("这里是error信息");

        return "hello world";
    }


    @PostMapping("/helloTest")
    public String helloTest(@RequestBody Users users, ServletRequest request, ServletResponse response){

        System.out.println("sout"+JSON.toJSON(users));

        log.info("这里是info信息");
        log.debug("这里是debug信息");
        log.trace("这里是trace信息");
        log.warn("这里是warn信息");
        log.error("这里是error信息");

        if (1==1)
            throw new RuntimeException("测试异常");

        return "hello world";


    }

}
