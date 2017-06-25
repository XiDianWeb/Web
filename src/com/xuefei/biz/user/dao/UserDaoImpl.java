package com.xuefei.biz.user.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xuefei.entity.User;
import com.xuefei.util.HBMUtil;

@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {

	@Override
	public void register(User user) {
		user.setTag(0);
		user.setRegtime(new Date());
		Session session = HBMUtil.getSession();
		session.save(user);
		HBMUtil.closeSession(session);

	}

	@Override
	public User getUserByCode(String code) {
		Session session = HBMUtil.getSession();
		Query q = session.createQuery("from User where code='"+code+"'");
		List<User> list = q.list();
		if(list.isEmpty())
			return null;
		User user=list.get(0);
		HBMUtil.closeSession(session);
		return user;
	}

	@Override
	public void updateTag(String code) {
		Session session = HBMUtil.getSession();
		Query q = session.createQuery("from User where code='"+code+"'");
		List<User> list = q.list();
		User u = list.get(0);
		u.setTag(1);
		session.update(u);
		HBMUtil.closeSession(session);
	}

	@Override
	public User getUser(User user) {
		String name=user.getName();
		String password=user.getPassword();
		Session session = HBMUtil.getSession();
		Query q = session.createQuery("from User where name='"+name+"' and password='"+password+"'");
		List<User> list = q.list();
		if(list.isEmpty())
			return null;
		User u=list.get(0);
		HBMUtil.closeSession(session);
		return u;
	}
}
