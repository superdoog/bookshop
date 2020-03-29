package com.lv.mapper;

import com.lv.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有user
     *
     * @return
     * @throws Exception
     */
    List<User> findAllUser() throws Exception;
}
