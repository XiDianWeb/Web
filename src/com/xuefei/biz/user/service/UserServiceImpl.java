package com.xuefei.biz.user.service;

import com.xuefei.biz.user.dao.UserDao;
import com.xuefei.biz.user.dao.UserDaoImpl;
import com.xuefei.entity.User;

public class UserServiceImpl implements UserService {
	
	UserDao dao=new UserDaoImpl();
	@Override
	public void register(User user) {
		dao.register(user);
	}

	@Override
	public User getUserByCode(String code) {
		return dao.getUserByCode(code);
	}

	@Override
	public void updateTag(String code) {
		dao.updateTag(code);
	}

	@Override
	public User getUser(User user) {
		return dao.getUser(user);
	}

}
