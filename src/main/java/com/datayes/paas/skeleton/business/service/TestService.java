package com.datayes.paas.skeleton.business.service;

import com.datayes.paas.skeleton.common.exception.CommonException;
import com.datayes.paas.skeleton.process.entity.User;

public interface TestService {

	public User getUser(long id) throws CommonException;

	public User createUser(User user);

	public void updateUser(User user) throws CommonException;

	public void deleteUser(long id) throws CommonException;
}