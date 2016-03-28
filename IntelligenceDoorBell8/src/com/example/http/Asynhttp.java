package com.example.http;

import java.io.IOException;

import org.apache.http.Header;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.example.allinformation.biaoshi;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * �������ӷ��������������������������
 */
public class Asynhttp {
   
	   
	       protected static final String TAG = null;
            private    String   photopath;
		
          
          public   Asynhttp(){
	    	   
	       }
	
	     //�������������Ϣ����֪��������Ҫ����
	
	    public     void     transitphoto(String path) throws IOException{
	    	   //��ȡͼƬ�ڷ������ϵĵ�ַ
	    	   AsyncHttpClient   client = new AsyncHttpClient();
	    	   RequestParams  params = new RequestParams();
	   //	   params.add("fileType", "photo_" +biaoshi.getDeviceId());
	    	    params.add("fileType", "photo_" + "201508");
	    	//   Log.i(TAG, params.toString());
	  	   client.post(path, params , new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					        //���ص���ͼƬ�ĵ�ַ
				        String  photo = new String(responseBody);
				        photopath =  photo.substring(photo.indexOf(":") + 2 , photo.indexOf("}") -1);
				        Log.i(TAG, photopath);
				    		        
				}
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
				       String  photo = new String(responseBody);
				       photopath = "��ȡʧ��";
				         
				}
			});
	    
	  	   
	    	    
	    }
	       
	    //�������������Ϣ����֪��������Ҫ�鿴����
	    public   static   void     transitaudio(String path) throws IOException{
	    	   //��ȡ��Ƶ�ļ��ڷ������ϵĵ�ַ
	    	   AsyncHttpClient   client = new AsyncHttpClient();
	    	   RequestParams  params = new RequestParams();
	    	   params.add("audio", "give me audio");
	    	   client.post(path, params , new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					        //���ص�����Ƶ�ĵ�ַ
				}
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					  
				}
			});
	    	   //�õ���Ƶ�ĵ�ַ�����ƶ��˲���
	    	   
	       }
	   
	   //�������������Ϣ����֪��������Ҫ�鿴��Ƶ
	    public  static   void    transitvideo(String path){
	    	   //��ȡ��Ƶ�ļ��ڷ������ϵ�λ��
	    	AsyncHttpClient   client  = new AsyncHttpClient();
	    	RequestParams params = new RequestParams();
	    	params.add("video", "give me video");
	    	client.post(path, params, new AsyncHttpResponseHandler() {
				
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					   
				}
				
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
			});
	    	//�õ���Ƶ��ַ�����ƶ��˽��в���
	    }
}