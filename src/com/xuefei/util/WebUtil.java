package com.xuefei.util;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.xuefei.entity.User;

public class WebUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static boolean checkTime(User user){
		Date date=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(user.getRegtime());
		cal.add(Calendar.DATE, 1);
		Date time = cal.getTime();
		if(time.after(date)){
			return true;
		}else {
			return false;
		}
	}
}

