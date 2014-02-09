package com.baidu.push.example;


import java.util.ArrayList;

import android.location.Address;
import android.os.AsyncTask;

import com.baidu.frontia.FrontiaApplication;

/*
 * 如果您的工程中实现了Application的继承类，那么，您需要将父类改为com.baidu.frontia.FrontiaApplication。
 * 如果您没有实现Application的继承类，那么，请在AndroidManifest.xml的Application标签中增加属性： 
 * <application android:name="com.baidu.frontia.FrontiaApplication"
 * 。。。
 */
public class MainApplication extends FrontiaApplication {
	private static ArrayList<AsyncTask<Void, Void, Boolean>> taskList = new ArrayList<AsyncTask<Void,Void,Boolean>>();
	@Override
	public void onCreate() {
		super.onCreate();
		
	}
	

}
