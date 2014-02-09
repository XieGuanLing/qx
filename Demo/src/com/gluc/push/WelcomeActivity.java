package com.gluc.push;

import com.baidu.push.example.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
public class WelcomeActivity extends Activity {
	
	private static String tag = WelcomeActivity.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initView();
    	//启动应用程序时请求一个 pushuserid 和 channelid
		PushManager.startWork(getApplicationContext(),
				PushConstants.LOGIN_TYPE_API_KEY,  
				"FdQTBxDBMVhQAQB3xQxPMkSW");
    }

	private void initView() {
		setContentView(R.layout.activity_welcome);
	}
	
	
	public void doClick(View view){
		Log.d(tag,"-----------------------------doClick");		
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
