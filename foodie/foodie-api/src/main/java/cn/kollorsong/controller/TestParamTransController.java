package cn.kollorsong.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: TestParamTransController
 * @Author: kollorsong
 * @Description: 一个测试springmvc传递参数的类
 * @DateTime: 2022/7/16 - 2:09 PM
 */
@RequestMapping("/testParamTrans")
@RestController
//swagger文档无法扫描接口
//@ApiIgnore
@Api(value = "测试参数传递",tags = "测试参数传递tags")
public class TestParamTransController {


    /**
     * @Author: kollorsong
     * @Description:
     * @DateTime: 2022/7/16 - 2:09 PM
     * @param: null
     * @Return:
     */
    @ApiOperation(value = "request方式",notes = "request方式notes")
    @RequestMapping(value = "/testParam1",method = RequestMethod.GET)
    public Object testParam1(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "---" + password);
        return null; // 不知道要返回什么页⾯ ,默认将 param1 路径名作为jsp⽂件名    }
    }


















}