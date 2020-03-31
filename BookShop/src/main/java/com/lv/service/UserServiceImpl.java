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
    public List<User> findAllUser(int currentPage, int pageSize) {
        List<User> users = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            users = userMapper.findAllUser(currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = userMapper.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteByuid(int uid) {
        int flag = 0;
        try {
            flag = userMapper.deleteByuid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User getUserById(int uid) {
        User user = null;
        try {
            user = userMapper.getUserById(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUser(User user) {
        int flag = 0;
        try {
        flag = userMapper.updateUser(user);
    } catch (Exception e) {
        e.printStackTrace();
    }
        return flag;
    }
}
