package com.baidu.push.example;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils {
	public static String post(String uri, Map<String, String> params){		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(uri);
		try { 
		   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(params.size()); 
		   for (Map.Entry<String, String> entry : params.entrySet()) {
			   //构建表单字段内容
	            nameValuePairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue())); 
	       }  
		   httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8")); 
		   
		   HttpResponse response = httpclient.execute(httppost); 
		   InputStream in=response.getEntity().getContent();
		   ByteArrayOutputStream baos = new ByteArrayOutputStream();
		   int ch=0;
		    while((ch=in.read())!=-1){
		      	baos.write(ch);
		    }      
		    byte[] data=baos.toByteArray();
		    baos.close();
		    return new String(data).trim();
		  } catch (Exception e) { 
		   e.printStackTrace(); 
		   return "error";
		  }
	}
	
	public static String get(String uri){
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(uri);
		 BufferedReader br = null;
		try{
			   HttpResponse response = httpclient.execute(httpGet); 
			   InputStream in=response.getEntity().getContent();
			   InputStreamReader isr = new InputStreamReader(in,"utf-8");
			   br = new BufferedReader(isr);
			   String line;
			   StringBuilder sBuilder = new StringBuilder() ;
			   while ((line = br.readLine()) != null ) {
	                    sBuilder.append(line);			
     			}
			   return sBuilder.toString();
		  } catch (Exception e) { 
			   return "{\"code\":0}";
		  }finally{
			  try {
					if(br != null){
						br.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		  }
		
	}
}