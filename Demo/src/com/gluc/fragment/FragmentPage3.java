package com.gluc.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;
import com.gluc.push.Constant;

public class FragmentPage3 extends ListFragment{

	private ProgressDialog dialog;
	
//	 @Override
//	public void onCreate(Bundle savedInstanceState) {
//	        super.onCreate(savedInstanceState);
//	        getContactList();
//	 }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		getContactList();
		return inflater.inflate(R.layout.fragment_contact, null);	
	}	
	 private void  getContactList(){
			final ArrayList<Map<String, Object>> contactList = new ArrayList<Map<String, Object>>();
			
	    	new AsyncTask<Void, Void, Boolean>(){
					@Override
					protected void onPreExecute() {
						super.onPreExecute();
						dialog = ProgressDialog.show(getActivity(), "", "正在刷新好友列表");
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
							  SimpleAdapter adapter = new SimpleAdapter(getActivity(), contactList, 
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