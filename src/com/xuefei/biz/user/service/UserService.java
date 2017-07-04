package com.xuefei.biz.user.service;

import com.xuefei.entity.User;

public interface UserService {
	public void register(User user);
	public User getUserByCode(String code);
	public void updateTag(String code);
	public User getUser(User user);
}
