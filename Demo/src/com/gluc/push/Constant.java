package com.gluc.push;

import java.util.HashMap;

public class Constant {
	
//		public static final String HOST = "http:// 10.0.2.2/uchome";
	    public static final String HOST ="http://gluchome.duapp.com";
		public static String m_auth;
		public static  HashMap<String, String>  registInfo;
		
		public static String pwd;
		public static String username;
		
		public static String userId;
		public static String channelId;
		
		public static String getUserId() {
			return userId;
		}
		public static void setUserId(String userId) {
			Constant.userId = userId;
		}
		public static String getChannelId() {
			return channelId;
		}
		public static void setChannelId(String channelId) {
			Constant.channelId = channelId;
		}

		public static String getPwd() {
			return pwd;
		}
		public static void setPwd(String pwd) {
			Constant.pwd = pwd;
		}
		public static String getUsername() {
			return username;
		}
		public static void setUsername(String username) {
			Constant.username = username;
		}
		public static HashMap<String, String> getRegistInfo() {
			return registInfo;
		}
		public static void setRegistInfo(HashMap<String, String> registInfo) {
			Constant.registInfo = registInfo;
		}
		
		public static String getM_auth() {
			return m_auth;
		}
		//登录或注册后调用该方法设置m_auth
		public static void setM_auth(String m_auth) {
			Constant.m_auth = m_auth;
		}
}
