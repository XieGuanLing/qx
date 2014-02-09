package com.gluc.push;

import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputFilter.AllCaps;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends Activity {
	
	private static String tag	= MessageActivity.class.getSimpleName();
	
	private TextView receiveMsgTV;
	private EditText toUserET;
	private EditText sendMsgET;
	private Button sendButton;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}
	
	  @Override    
	  protected void onNewIntent(Intent intent) {    
	        
	        Log.d(tag, "---------------------------onNewIntent  intent = "+intent);   
	        setIntent(intent);
	        String allmsg = receiveMsgTV.getText().toString();
	        
	        
	        super.onNewIntent(intent);   
	  }
	
   private void initView(){
		   setContentView(R.layout.activity_message);
		   receiveMsgTV = (TextView) findViewById(R.id.receive_msg);
		   toUserET = (EditText) findViewById(R.id.to_username);
		   sendMsgET = (EditText) findViewById(R.id.send_msg);
		   sendButton = (Button) findViewById(R.id.sendButton);
   }
   
   private void doClick(View view){
	       switch (view.getId()) {
		case R.id.sendButton:
			  sendMsg();
			break;

		default:
			break;
		}
   }

	private void sendMsg() {
		 new AsyncTask<Void, Void, Boolean>() {
				@Override
				protected void onPreExecute() {
					super.onPreExecute();
				}

				@Override
				protected Boolean doInBackground(Void... params) {
					String username = toUserET.getText().toString();
					String msg = sendMsgET.getText().toString();
					Log.d(tag, "---------------send----------"+username+"--------"+msg);
					
					String content = HttpUtils.get(Constant.HOST+
							"/capi/cp.php?ac=pm&op=send&pmsubmit=true&username="+username+
							"&message="+msg+
							"&m_auth="+Constant.getM_auth());
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
						
				}
			}.execute();
	}
   
}
