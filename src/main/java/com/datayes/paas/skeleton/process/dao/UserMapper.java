package com.datayes.paas.skeleton.process.dao;

import com.datayes.paas.skeleton.process.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    public List<User> selectAll();

    public User select(@Param("id") long id);

    public int insert(User user);

    public int update(User user);

    public int delete(@Param("id") long id);
}
