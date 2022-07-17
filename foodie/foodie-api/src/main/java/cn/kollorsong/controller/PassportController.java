package cn.kollorsong.controller;

import cn.kollorsong.pojo.Users;
import cn.kollorsong.service.UsersService;
import cn.kollorsong.utils.CommonResultResponse;
import cn.kollorsong.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pass")
@Slf4j
public class PassportController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/testU")
    public CommonResultResponse getUsers(String name){
        if (StringUtils.isBlank(name))
            return CommonResultResponse.errorMsg("请输入用户名");
        System.out.printf("/users/getUsers id = %s \n",name);
        boolean res = usersService.userIsExist(name);
        if (res)
            return CommonResultResponse.errorMsg("用户已存在");
        return CommonResultResponse.ok();
    }

}
