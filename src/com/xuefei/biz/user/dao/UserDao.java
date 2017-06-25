package com.xuefei.biz.user.dao;

import com.xuefei.entity.User;

public interface UserDao {
	public void register(User user);
	public User getUserByCode(String code);
	public void updateTag(String code);
	public User getUser(User user);
}
