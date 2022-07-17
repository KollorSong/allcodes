package cn.kollorsong.controller;

import cn.kollorsong.pojo.Users;
import cn.kollorsong.service.UsersService;
import cn.kollorsong.utils.CommonResultResponse;
import cn.kollorsong.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
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
    public CommonResultResponse getUsers( String id){
        System.out.printf("/users/getUsers id = %s \n",id);
        Users users = usersService.getUsersById(id);
        String test = "123";
        CommonResultResponse<String> ok = CommonResultResponse.ok(test);
        System.out.println(ok);
        return ok;
    }

}
