package com.gluc.push;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.push.example.HttpUtils;
import com.baidu.push.example.R;
import com.gluc.entity.ChatEntity;

public class ChatActivity extends Activity {
	
	private static String tag = ChatActivity.class.getSimpleName();
	
	private Button sendButton = null;
	private EditText contentEditText = null;
	private ListView chatListView = null;
	private List<ChatEntity> chatList = null;
	private ChatAdapter chatAdapter = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
       initView();
        
    }
    
    public void doClick(View view){
    	if (!contentEditText.getText().toString().equals("")) {
			//发送消息
			sendMsg();
		}else {
			Toast.makeText(ChatActivity.this, "Content is empty", Toast.LENGTH_SHORT).show();
		}
    }
    
    private void initView(){
    	 requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.activity_chat);
         
         contentEditText = (EditText) this.findViewById(R.id.et_content);
         sendButton = (Button) this.findViewById(R.id.btn_send);
         chatListView = (ListView) this.findViewById(R.id.listview);
         
         chatList = new ArrayList<ChatEntity>();
         //chatList里面要有内容，不然不能显示
       ChatEntity chatEntity = new ChatEntity();
       chatList.add(chatEntity);
         
//       ChatEntity chatEntity = null;
//       for (int i = 0; i < 2; i++) {
//         	chatEntity = new ChatEntity();
// 			if (i % 2 == 0) {
// 				chatEntity.setComeMsg(false);
// 				chatEntity.setContent("Hello");
// 				chatEntity.setChatTime("2012-09-20 15:12:32");
// 			}else {
// 				chatEntity.setComeMsg(true);
// 				chatEntity.setContent("Hello,nice to meet you!");
// 				chatEntity.setChatTime("2012-09-20 15:13:32");
// 			}
// 			chatList.add(chatEntity);
// 		 }
         
         chatAdapter = new ChatAdapter(this,chatList);
         chatListView.setAdapter(chatAdapter);
    }
    
    private void showMsg(){
    	ChatEntity chatEntity = new ChatEntity();
    	//yyyy-MM-dd HH:mm:ss
    	SimpleDateFormat dateformat=new SimpleDateFormat("HH:mm:ss");
    	chatEntity.setChatTime( dateformat.format(new Date()) );
    	chatEntity.setContent(contentEditText.getText().toString());
    	chatEntity.setComeMsg(false);
    	
    	chatList.add(chatEntity);
    	chatAdapter.notifyDataSetChanged();
    	
    	chatListView.setSelection(chatList.size() - 1);
    	contentEditText.setText("");
    }
    
    private void sendMsg() {
		 new AsyncTask<Void, Void, Boolean>() {
				@Override
				protected void onPreExecute() {
					super.onPreExecute();
				}

				@Override
				protected Boolean doInBackground(Void... params) {
					String username = "qiuxia";
					String msg = "努力工作";
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
					Log.d(tag, "result-------------------- "+result );
					if(result){
						showMsg();
					}
				}
			}.execute();
	}
    
    private  class ChatAdapter extends BaseAdapter{
    	private Context context = null;
    	private List<ChatEntity> chatList = null;
    	private LayoutInflater inflater = null;
    	private int COME_MSG = 0;
    	private int TO_MSG = 1;
    	
    	public ChatAdapter(Context context,List<ChatEntity> chatList){
    		this.context = context;
    		this.chatList = chatList;
    		inflater = LayoutInflater.from(this.context);
    	}

		@Override
		public int getCount() {
			return chatList.size();
		}

		@Override
		public Object getItem(int position) {
			return chatList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public int getItemViewType(int position) {
			// 区别两种view的类型，标注两个不同的变量来分别表示各自的类型
		 	ChatEntity entity = chatList.get(position);
		 	if (entity.isComeMsg())
		 	{
		 		return COME_MSG;
		 	}else{
		 		return TO_MSG;
		 	}
		}

		@Override
		public int getViewTypeCount() {
			// 这个方法默认返回1，如果希望listview的item都是一样的就返回1，我们这里有两种风格，返回2
			return 2;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ChatHolder chatHolder = null;
			if (convertView == null) {
				chatHolder = new ChatHolder();
				//根据消息来源选择不同样式
				if (chatList.get(position).isComeMsg()) {
					convertView = inflater.inflate(R.layout.chat_from_item, null);
				}else {
					convertView = inflater.inflate(R.layout.chat_to_item, null);
				}
				chatHolder.timeTextView = (TextView) convertView.findViewById(R.id.tv_time);
				chatHolder.contentTextView = (TextView) convertView.findViewById(R.id.tv_content);
				chatHolder.userImageView = (ImageView) convertView.findViewById(R.id.iv_user_image);
				convertView.setTag(chatHolder);
			}else {
				chatHolder = (ChatHolder)convertView.getTag();
			}
			
			chatHolder.timeTextView.setText(chatList.get(position).getChatTime());
			chatHolder.contentTextView.setText(chatList.get(position).getContent());
			chatHolder.userImageView.setImageResource(chatList.get(position).getUserImage());
			
			return convertView;
		}
		//ChatAdapter的内部类
		private  class ChatHolder{
			private TextView timeTextView;
			private ImageView userImageView;
			private TextView contentTextView;
		}
    	
    }
}