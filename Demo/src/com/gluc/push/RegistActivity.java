package com.gluc.push;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;



public class RegistActivity extends Activity {

	private static String tag = RegistActivity.class.getSimpleName();
	
	private EditText usernameEditText;
	private EditText pwdEditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initView();
        initParam();
    }
    
    private void initView(){
    	setContentView(R.layout.activity_regist);
    	usernameEditText = (EditText) findViewById(R.id.regist_username);
    	pwdEditText = (EditText) findViewById(R.id.regist_pwd);
    }
    
	private void initParam(){
		new AsyncTask<Void, Void, Boolean>() {
			@Override
			protected Boolean doInBackground(Void... params) {
				
				String content = HttpUtils.get(Constant.HOST+
						"/capi/do.php?ac=register&op=seccode");
				try {
					JSONObject jsonContent = new JSONObject(content);
					JSONObject dataJOjbect = jsonContent.getJSONObject("data");
					HashMap<String , String >registInfo = new HashMap<String, String>();
					registInfo.put("seccode", dataJOjbect.getString("seccode"));
					registInfo.put("m_auth", dataJOjbect.getString("seccode_auth"));
					Constant.setRegistInfo(registInfo);
					//注册返回的seccode_auth当m_auth用
					Constant.setM_auth(dataJOjbect.getString("seccode_auth"));
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return true;
			}
			
			@Override
			protected void onPostExecute(Boolean result) {
				super.onPostExecute(result);
				if(result){
					Log.d(tag, "----------get seccode  successed ");
				}else {
					Log.d(tag, "----------get seccode faild");
				}
			}
			
		}.execute();
		
	}
    
    public void doClick(View v){
    	final String username = usernameEditText.getText().toString();
    	final String pwd = pwdEditText.getText().toString();
    	 
    	
    	 new AsyncTask<Void, Void, Boolean>(){
        		
    			@Override
    			protected void onPreExecute() {
    				super.onPreExecute();
    				
    			}

    			@Override
    			protected Boolean doInBackground(Void... params) {
    				
    			    HashMap<String , String> registInfo = Constant.getRegistInfo();
    				String seccode = registInfo.get("seccode");
    				String m_auth = registInfo.get("m_auth"); 
    				
    				if(seccode != null && m_auth != null){
    						String content = HttpUtils.get(Constant.HOST+
    								"/capi/do.php?ac=register&registersubmit=true" +
    								"&username=" +username+
    								"&password=" +pwd+
    								"&password2="+pwd+
    								"&seccode="+seccode+
    								"&m_auth="+m_auth);
    						
    						Log.d(tag, content);
    						try {
    							JSONObject jsonContent = new JSONObject(content);
    							JSONObject dataJOjbect = jsonContent.getJSONObject("data");
    							Constant.setM_auth(dataJOjbect.getString("m_auth"));
    							
    						} catch (JSONException e) {
    							e.printStackTrace();
    							return false;
    						}
    				}
    				return true;

    			}
    			
    			@Override
    			protected void onPostExecute(Boolean result) {
    				super.onPostExecute(result);
    				//注册成功后会得到m_auth, 所以可以直接进入主页
    				if (result) {
    					 Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_LONG).show();
    					 //Calling startActivity() from outside of an Activity context 
    					 //requires the FLAG_ACTIVITY_NEW_TASK flag. 
    					 
    					 //Intent intent = new Intent(context, LogoutActivity.class);
    					 //context.startActivity(intent);
    				}
    			}
        	}.execute();
    }
    
}
