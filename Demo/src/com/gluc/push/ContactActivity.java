package com.gluc.push;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;

public class ContactActivity extends ListActivity {
	
	private ProgressDialog dialog;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        getContactList();
//	        SimpleAdapter simpleAdapter = new SimpleAdapter(this, contactList,
//                    R.layout.contact_item,
//                    new String[] { "img", "name" },
//                    new int[] { R.id.img,R.id.name});
//         setListAdapter(simpleAdapter);
	      
	    }

	 private void  getContactList(){
			final ArrayList<Map<String, Object>> contactList = new ArrayList<Map<String, Object>>();
			
	    	new AsyncTask<Void, Void, Boolean>(){
					@Override
					protected void onPreExecute() {
						super.onPreExecute();
						dialog = ProgressDialog.show(ContactActivity.this, "", "正在刷新好友列表");
					}

					@Override
					protected Boolean doInBackground(Void... params) {
						String content = HttpUtils.get(Constant.HOST+"/capi/space.php?do=friend&isinsert=true&m_auth="+Constant.getM_auth());
						try {
							JSONObject data = new JSONObject(content).getJSONObject("data");
							JSONArray cArray = data.getJSONArray("friends");
							int m = cArray.length();
							JSONObject contactJO;
							HashMap<String ,Object> cMap ;
							for(int i = 0; i<m; i++){
								contactJO = (JSONObject) cArray.get(i);
								//每次都要构建cMap;
								cMap = new HashMap<String, Object>();
								cMap.put("username", contactJO.getString("username"));
								cMap.put("avatar", R.drawable.avatar);
								contactList.add(cMap);
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
						return true;
					}
					
					@Override
					protected void onPostExecute(Boolean result) {
						super.onPostExecute(result);
						
						if(result){
							  SimpleAdapter adapter = new SimpleAdapter(ContactActivity.this, contactList, 
									  R.layout.contact_item, 
									  new String[] { "avatar", "username" },
					                  new int[] { R.id.avatar,R.id.username});
							  setListAdapter(adapter);
						}
						dialog.cancel();
					}
			}.execute();
			
	 }
}
