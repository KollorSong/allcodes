package cn.kollorsong.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: TestParamTransController
 * @Author: kollorsong
 * @Description: 一个测试springmvc传递参数的类
 * @DateTime: 2022/7/16 - 2:09 PM
 */
@RequestMapping("/testParamTrans")
@Controller
public class TestParamTransController {


    /**
     * @Author: kollorsong
     * @Description:
     * @DateTime: 2022/7/16 - 2:09 PM
     * @param: null
     * @Return:
     */
    public Object testParam1(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "---" + password);
        return null; // 不知道要返回什么页⾯ ,默认将 param1 路径名作为jsp⽂件名    }
    }


















}