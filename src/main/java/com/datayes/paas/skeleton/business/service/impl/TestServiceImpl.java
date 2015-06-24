package com.datayes.paas.skeleton.business.service.impl;

import com.datayes.paas.skeleton.business.service.TestService;
import com.datayes.paas.skeleton.common.exception.CommonException;
import com.datayes.paas.skeleton.common.model.ResultType;
import com.datayes.paas.skeleton.process.dao.UserMapper;
import com.datayes.paas.skeleton.process.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Author: qianzhong.fu
 * Date: 2015/6/4
 * Time: 17:59
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public User getUser(long id) throws CommonException {
        User user = userMapper.select(id);
        if (user == null)
            throw new CommonException(ResultType.NOT_EXIST_USER);
        return user;
    }

    @Override
    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public void updateUser(User user) throws CommonException {
        int updatedRows = userMapper.update(user);
        if (updatedRows < 1)
            throw new CommonException(ResultType.NOT_EXIST, "user not exist");
    }

    @Override
    public void deleteUser(long id) throws CommonException {
        int updatedRows = userMapper.delete(id);
        if (updatedRows < 1)
            throw new CommonException(ResultType.NOT_EXIST, "user not exist");
    }
}
