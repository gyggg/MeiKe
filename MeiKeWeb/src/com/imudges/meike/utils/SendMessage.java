package com.imudges.meike.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.junit.Test;
import org.objectweb.asm.xwork.tree.TryCatchBlockNode;

public class SendMessage {
	
	private String checkCode;
	
	private void createCheckCode(){
		checkCode="";
		String base[] = {"0","1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < 4; i++) {
			int RandNum=new Random().nextInt(base.length);
			this.checkCode+=base[RandNum];
		}
	}
	private String getCheckCode(){
		return checkCode;
	}
	public String sendSMS(String phoneNum){
		String username = "yanyongjie";//���ű��ʻ���
		String pass = new MD5().Md5("15296603340yyjqq");//���ű��ʻ����룬md5���ܺ���ַ���
		String phone = phoneNum;//�绰����
		String content="";
		try {
			createCheckCode();
			content = java.net.URLEncoder.encode("�����Ρ������֤��Ϊ"+getCheckCode()+"��������֤��͸¶�������ˡ�","utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//��������
		httpSend send = new httpSend("http://www.smsbao.com/sms?u="+username+"&p="+pass+"&m="+phone+"&c="+content);
		try {
			send.send();
		} catch (Exception e) {
			e.printStackTrace();
		}/**/
		return checkCode;
	}

}