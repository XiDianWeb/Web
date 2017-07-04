package com.xuefei.biz.user.action;

import com.opensymphony.xwork2.ModelDriven;
import com.xuefei.biz.user.service.UserService;
import com.xuefei.biz.user.service.UserServiceImpl;
import com.xuefei.entity.User;
import com.xuefei.util.BaseAction;
import com.xuefei.util.SendMail;
import com.xuefei.util.WebUtil;

public class UserAction extends BaseAction implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	private User user=new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String register() throws Exception {
		user.setCode(WebUtil.getUUID());
		UserService service=new UserServiceImpl();
		service.register(user);
		new Thread(new SendMail(user)).start();	
		return SUCCESS;
	}

	public String login() throws Exception {
		UserService service=new UserServiceImpl();
		User u = service.getUser(user);
		if(u==null){
			requestMap.put("msg", "登陆失败，该用户不存在");
			return "message";
		} else {
			if(u.getTag()==0) {
				requestMap.put("msg", "登陆失败，该用户未激活");
				return "message";
			}
			else {
				sessionMap.put("user", user);
				return "login";
			}
		}
	}

	public String active() throws Exception {
		UserService service=new UserServiceImpl();
		User u = service.getUserByCode(user.getCode());
		if(u!=null){
			if(WebUtil.checkTime(u)){
				service.updateTag(user.getCode());
				requestMap.put("msg", "该用户激活成功，现已可以登陆");
				return "message";
			}else {
				requestMap.put("msg", "激活失败，已超出24小时，请重新注册");
				return "message";
			}
		} else{
			requestMap.put("msg", "激活失败，该用户不存在");
			return "message";
		}
	}

}
