package cn.kollorsong.service;

import cn.kollorsong.pojo.Users;

public interface UsersService {

    Users getUsersById(String id);


    //TODO 判断用户名是否存在
    boolean userIsExist(String name);

    //



}
