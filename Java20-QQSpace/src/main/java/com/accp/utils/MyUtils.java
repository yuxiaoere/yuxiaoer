package com.accp.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.serializer.CalendarCodec;

public class MyUtils {
	public static String dateToString(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int nowYear = c.get(Calendar.YEAR);
		int now = c.get(Calendar.DAY_OF_YEAR);
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int day = c.get(Calendar.DAY_OF_YEAR);
		if(nowYear == year) {
			if(now-day==2) {
				sdf.applyPattern("前天 hh:mm:ss");
			}else if(now-day==1){
				sdf.applyPattern("昨天 hh:mm:ss");
			}else if(now == day) {
				sdf.applyPattern("今天 hh:mm:ss");
			}else {
				sdf.applyPattern("MM-dd hh:mm:ss");
			}
		}else {
			sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		
		return sdf.format(date);
	}
}
