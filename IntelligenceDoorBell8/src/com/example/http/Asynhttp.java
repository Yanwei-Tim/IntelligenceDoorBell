package com.example.http;

import java.io.IOException;

import org.apache.http.Header;

import android.graphics.Bitmap;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * �������ӷ��������������������������
 */
public class Asynhttp {
   
	   
	       public   Asynhttp(){
	    	   
	       }
	
	     //�������������Ϣ����֪��������Ҫ����
	
	    public   static     Bitmap     transitphoto(String path) throws IOException{
	    	   //��ȡͼƬ�ڷ������ϵĵ�ַ
	    	    Bitmap    bitmap ;
	    	   AsyncHttpClient   client = new AsyncHttpClient();
	    	   RequestParams  params = new RequestParams();
	    	   params.add("photo", "give me photo");
	    	   client.post(path, params , new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					// TODO Auto-generated method stub
					        //���ص���ͼƬ�ĵ�ַ
				}
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					
				}
			});
	    	   //�õ�ͼƬ�ĵ�ַ���������ƶ�����ʾ��
	    	   bitmap  = httpUtils.httpgetphoto(path);
	    	   return bitmap;
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