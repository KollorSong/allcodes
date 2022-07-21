package cn.kollorsong.controller;

import cn.kollorsong.pojo.Users;
import cn.kollorsong.service.UsersService;
import cn.kollorsong.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/getUsers")
    public String getUsers( String id) throws Exception{
        System.out.printf("/users/getUsers id = %s",id);
        Users users = usersService.getUsersById(id);
        if (1==1)
            throw new RuntimeException("ceshiyichang");
        return JsonUtils.objectToJson(users);
    }

}
