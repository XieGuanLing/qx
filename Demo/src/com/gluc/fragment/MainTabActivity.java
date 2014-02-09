package com.gluc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.push.example.R;
import com.gluc.push.LoginActivity2;
import com.gluc.push.RegistActivity;

public class MainTabActivity extends FragmentActivity{	
	
	private static String tag = MainTabActivity.class.getSimpleName();
	private FragmentTabHost mTabHost;
	private LayoutInflater layoutInflater;
		
	private Class fragmentArray[] = {FragmentPage1.class,FragmentPage2.class,
			FragmentPage3.class,FragmentPage4.class,FragmentPage5.class};
	
	private int mImageViewArray[] = {R.drawable.tab_home_btn,R.drawable.tab_message_btn,
			 R.drawable.tab_selfinfo_btn, R.drawable.tab_square_btn,R.drawable.tab_more_btn};
	
	//Tab选项卡的文字
	private String mTextviewArray[] = {"首页", "消息", "好友", "广场", "用户中心"};
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_main);
        
        initView();
      //启动应用程序时请求一个 pushuserid 和 channelid
      		PushManager.startWork(getApplicationContext(),
      				PushConstants.LOGIN_TYPE_API_KEY,  
      				"FdQTBxDBMVhQAQB3xQxPMkSW");
    }
	 
	private void initView(){
		//实例化布局对象
		layoutInflater = LayoutInflater.from(this);
				
		//实例化TabHost对象
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);	
		
		int count = fragmentArray.length;	
		for(int i = 0; i < count; i++){	
			//为每一个Tab按钮设置图标、文字
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i])
														   .setIndicator( getTabItemView(i) );
			//将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			//设置Tab按钮的背景
			mTabHost.getTabWidget()
							.getChildAt(i)
			 				.setBackgroundResource(R.drawable.selector_tab_background);
		}
	}
				
	/**
	 * 给Tab按钮设置图标和文字
	 */
	private View getTabItemView(int index){
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
	
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		
		TextView textView = (TextView) view.findViewById(R.id.textview);		
		textView.setText(mTextviewArray[index]);
	
		return view;
	}
	
	public void doClick(View view){
		Intent  intent;
		switch (view.getId()) {
		case R.id.welcome_login	:
			intent = new Intent(this, LoginActivity2.class);
			startActivity(intent);
			break;
		case R.id.welcome_regist	:
			intent = new Intent(this, RegistActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
