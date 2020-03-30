package com.lv.mapper;

import com.lv.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有user
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<User> findAllUser(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 插入
     * @param user
     * @return
     */
    int insert(User user);

    int getCount();

    int deleteByuid(@Param("uid") int uid);

}
