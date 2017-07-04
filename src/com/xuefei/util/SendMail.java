package com.xuefei.util;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.xuefei.entity.User;

public class SendMail implements Runnable {
	User user=null;
	public SendMail(User user){
		this.user=user;
	}
	@Override
	public void run() {
		Properties props=new Properties();
		props.setProperty("mail.host", "smtp.126.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Session s=Session.getDefaultInstance(props, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("xuefei_19951015@126.com","xueFEI1193");
			}
		});
		
		s.setDebug(true);
		
		MimeMessage msg=new MimeMessage(s);
		try {
			msg.setFrom(new InternetAddress("xuefei_19951015@126.com"));
			msg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			msg.setSubject("这是一封激活邮件");
			String html="亲爱的"+user.getName()+":<br>";
			html+="&nbsp;&nbsp;恭喜您注册本网站会员，请于24小时内点击以下链接激活用户<br>";
			html+="&nbsp;&nbsp;<a href='http://localhost/WebOnline/user_active?code="+user.getCode()+"'>激活用户</a>";
			msg.setContent(html, "text/html;charset=utf-8");//设置邮件信息
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
