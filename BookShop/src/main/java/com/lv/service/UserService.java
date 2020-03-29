package com.lv.service;

import com.lv.pojo.User;

import java.util.List;

/**
 * @author lv
 */
public interface UserService {
    /**
     * 查询所有user
     *
     * @return
     */
    List<User> findAllUser();

}
