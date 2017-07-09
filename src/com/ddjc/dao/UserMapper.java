package com.ddjc.dao;

import com.ddjc.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User login(User user);

	User findUserBycode(String usercode);

    List<User> selectAll();
}