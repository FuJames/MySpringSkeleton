package com.fqz.skeleton.service;

import com.fqz.skeleton.exception.CommonException;
import com.fqz.skeleton.model.entity.User;

public interface TestService {

	public User getUser(long id) throws CommonException;

	public User createUser(User user);

	public void updateUser(User user) throws CommonException;

	public void deleteUser(long id) throws CommonException;
}