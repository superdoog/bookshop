package com.lv.service;

import com.lv.pojo.User;

import java.util.List;

/**
 * @author lv
 */
public interface UserService {

    List<User> findAllUser(int currentPage, int pageSize);

    int addUser(User user);

    int getCount();

    int deleteByuid(int uid);

    User getUserById(int uid);

    User getUserByuname(String uname);

    int updateUser(User user);


}
