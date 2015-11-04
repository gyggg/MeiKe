package com.imudges.meike.utils;

import javax.servlet.http.Cookie;

import com.imudges.meike.bean.Users;
import com.imudges.meike.service.UsersService;



public class GetUserIdByCookies {
	/**
	 * @param cookies Ϊ����
	 * @return 0 ��ʾ��ȡʧ�� ������ֵ��Ϊ��ȡ������ֵ*/
	public static int getUserId(Cookie[] cookies){
		String hashCode=null;
		if (cookies==null) {
			return 0;
		}
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("hashCode")) {
				hashCode=cookies[i].getValue();
				break;
			}
		}
		if (hashCode!=null) {
			Users users=new UsersService().getUsersByHashCode(hashCode);
			if (users==null) {
				return 0;
			}
			return users.getUsersId();
		}
		return 0;
	}
}
