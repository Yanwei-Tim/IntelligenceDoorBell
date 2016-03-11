package com.example.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.loopj.android.http.HttpGet;

/**
 *  ����web�����������һ��json����
 * @author lenovo
 *
 */
public class httpUtils {
    
	  public   httpUtils(){
		  
	  }
	    
	  //���ӷ���������÷��������ص������������д������json�ַ���
	 //����HttpClient���������⻹��URLConnection�ķ���
	  public  static  String httpgetjsonContent(String path) throws ClientProtocolException, IOException{
		  
		      HttpClient  client = new DefaultHttpClient();
		      HttpGet  httpget = new HttpGet(path);
		      HttpResponse response = client.execute(httpget);  //��÷���������Ӧ
		      int code;
		      code = response.getStatusLine().getStatusCode();
		      if(code == 200){
		    	   InputStream is = response.getEntity().getContent() ; //��÷��������ع�������
		    	   String text;
		    	   text = streamtools.readInputStream(is);
	               return text;	 
		      }
		      else{
		    	  return null;
		      }
	  }
}
