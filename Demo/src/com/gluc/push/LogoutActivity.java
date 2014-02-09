package com.gluc.push;

import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class LogoutActivity extends Activity {
	
	private static String tag = LogoutActivity.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initView();
        
    }

	private void initView() {
		setContentView(R.layout.activity_logout);
	}
	
	
	public void doClick(View view){
		switch (view.getId()) {
		case R.id.logout	:
			logout();
			break;
		default:
			break;
		}
	}
	
	private void logout(){
		 new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}

			@Override
			protected Boolean doInBackground(Void... params) {
				String content = HttpUtils.get(Constant.HOST+"/capi/cp.php?ac=common&op=logout&m_auth="+Constant.getM_auth());
				try {
					JSONObject jsonContent = new JSONObject(content);
					int code = Integer.parseInt(jsonContent.getString("code"));
					if (code == 0) {
						return true;
					}
					return false;
				} catch (JSONException e) {
					e.printStackTrace();
					return false;
				}
			}
			
			@Override
			protected void onPostExecute(Boolean result) {
				super.onPostExecute(result);
				if(result){
					Toast.makeText(LogoutActivity.this, "退出成功", Toast.LENGTH_LONG).show();
					 Intent intent = new Intent(LogoutActivity.this, WelcomeActivity.class);
					 startActivity(intent);
				}else{
					Toast.makeText(LogoutActivity.this, "出错了", Toast.LENGTH_LONG).show();
				}
					
			}
		}.execute();
	}
}
