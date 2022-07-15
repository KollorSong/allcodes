package cn.kollorsong.service.impl;

import cn.kollorsong.mapper.UsersMapper;
import cn.kollorsong.pojo.Users;
import cn.kollorsong.service.UsersService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users getUsersById(String id) {
        Example userexample = new Example(Users.class);
        Example.Criteria criteria = userexample.createCriteria();
        criteria.andEqualTo("id",id);
        Users user = usersMapper.selectOneByExample(userexample);
        return user;
    }


}
