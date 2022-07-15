package cn.kollorsong.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
