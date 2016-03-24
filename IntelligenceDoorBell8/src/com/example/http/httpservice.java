package com.example.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.*;

import android.util.Log;

/**
 * 
 * @author ����json�ṹ���ַ���
 *
 */


public class httpservice {
	
	  
	private static final String TAG = null;

	public static String UrlPost(String path,String jsonstring) throws IOException{
	    	
	    	URL url = new URL(path);
	    	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	    	conn.setReadTimeout(5000);
	    	conn.setRequestMethod("POST");
	    	String data = "jsonstring="+jsonstring;
	    	conn.setRequestProperty("Content-Type",  
	                "application/x-www-form-urlencoded");  
	    	conn.setRequestProperty("Content-Length",  
	                String.valueOf(data.length()+""));  
	    	conn.setDoOutput(true);    //��������д����
			conn.setDoInput(true);     //�������ڶ�����
			OutputStream os = conn.getOutputStream();   //����������������������������д����
			os.write(data.getBytes());             
			int code = conn.getResponseCode();
			Log.i(TAG, "sdfdsf");
			if(code == 200){
				
				InputStream is = conn.getInputStream();
				String text = streamtools.readInputStream(is);
				Log.i(TAG, "sdfdsf");
				return text;
			}
			else
				 return null;
	      }
	
	
}
	


