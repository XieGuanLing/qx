package com.gluc.push;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity2 extends Activity {

	private static String tag = LoginActivity2.class.getSimpleName();
	
	private EditText usernameEditText;
	private EditText pwdEditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initView();
        
    }
    
    private void initView(){
    	setContentView(R.layout.activity_login);
    	usernameEditText = (EditText) findViewById(R.id.login_username);
    	pwdEditText = (EditText) findViewById(R.id.login_pwd);
    }
    
    public void doClick(View v){
//	    String username = usernameEditText.getText().toString();
//	    String pwd = pwdEditText.getText().toString();
		String username = "1396636115";
		String pwd = "guan";
		String userId = Constant.getUserId();
		String channelId = Constant.getChannelId();
		if(userId != null && channelId != null){
	    	login(username,pwd,userId,channelId);
		}else {
			Log.d(tag, "channelId is null");
		}

//    	Constant.setPwd(pwd);
//    	Constant.setUsername(username);
//    	//请求一个 pushuserid 和 channelid
//		PushManager.startWork(getApplicationContext(),
//				PushConstants.LOGIN_TYPE_API_KEY,  
//				"FdQTBxDBMVhQAQB3xQxPMkSW");


    }
    
private void login(final String username,final String pwd,final String userId,final String channelId) {
    	
    	new AsyncTask<Void, Void, Boolean>(){
				@Override
				protected Boolean doInBackground(Void... params) {
					String content = HttpUtils.get(Constant.HOST+
							"/capi/do.php?ac=login&loginsubmit=true" +
							"&username=" +username+
							"&password="+pwd+
							"&pushid=" +userId+
							"&channelid=" +channelId);
					
					try {
						JSONObject jsonContent = new JSONObject(content);
						
						String m_auth  = jsonContent.getJSONObject("data").getString("m_auth");
						Constant.setM_auth(m_auth);
						Log.d(tag, m_auth);
						
						JSONObject pm =  jsonContent.getJSONObject("data").getJSONObject("pm");
					    if(pm != null){
					    	int count = Integer.parseInt(pm.getString("count"));
							if(count != 0){
								JSONArray pmArray = pm.getJSONArray("data");
								for(int i=0; i < count;  i++){
									JSONObject pmObject =  (JSONObject) pmArray.get(i);
									Log.d(tag,pmObject.toString());
								}
								
							}
					    }
						
					} catch (JSONException e) {
						e.printStackTrace();
						return false;
					}
					return true;
				}
				
				@Override
				protected void onPostExecute(Boolean result) {
					super.onPostExecute(result);
					Context context = LoginActivity2.this;
					if(result){
						//Toast.makeText(context, "登录成功", Toast.LENGTH_LONG).show();
						//保存username 和 pwd 信息后进入主页面
						 SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
						 Editor editor =  sp.edit();
						 editor.putString("username", username);
						 editor.putString("pwd", pwd);
						 editor.commit();
						//跳转到消息页面
						 Intent intent = new Intent(context, ContactActivity.class);
//						 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						 context.startActivity(intent);
						
					}
				}
			}.execute();
	}

    
}
