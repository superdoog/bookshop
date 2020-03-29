package com.lv.service;

import com.lv.mapper.UserMapper;
import com.lv.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lv
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        List<User> users = null;
        try {
            users = userMapper.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
