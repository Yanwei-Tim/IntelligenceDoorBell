package com.example.uiproject;

import java.io.IOException;

import org.apache.http.Header;

import com.example.allinformation.biaoshi;
import com.example.http.Asynhttp;
import com.example.http.httpUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.image.SmartImageView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

public class showphoto   extends Activity{
          
	    private static final String TAG = null;
		private  SmartImageView    showphoto;
	    private  Bitmap     bitmap;
	    private   String    photopath;
	
		    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	    	requestWindowFeature(Window.FEATURE_NO_TITLE);    //ȫ��
	    	setContentView(R.layout.photo);
	       showphoto  = (SmartImageView)findViewById(R.id.photo);
	
	     	 initfunction();                             //�������������Ϣ��������ʾ���ֻ���
	       
		    }
	    
   	//�������������Ϣ�����ͼƬ��λ�ã��õ�ͼƬ��λͼ����ʾ���ƶ���
	 public   void    initfunction(){
		          
		 try {
		   	String path = "http://219.244.48.159:8080/WeChat/sendPhotoSmartDogAction.action";
			//	bitmap =      Asynhttp.transitphoto(path);
		    transitphoto(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
	 }
	  
	 
	 public     void     transitphoto(String path) throws IOException{
  	   //��ȡͼƬ�ڷ������ϵĵ�ַ
  	   AsyncHttpClient   client = new AsyncHttpClient();
  	   RequestParams  params = new RequestParams();
 	 //  params.add("fileType", "photo_" +biaoshi.getDeviceId());
  	   params.add("fileType", "photo_" + "201508");      //���Ե�ǰ�󶨵��豸
  	//   Log.i(TAG, params.toString());
	   client.post(path, params , new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				// TODO Auto-generated method stub
				        //���ص���ͼƬ�ĵ�ַ
			        String  photo = new String(responseBody);
			        photopath =  photo.substring(photo.indexOf(":") + 2 , photo.indexOf("}") -1);
			      //  Log.i(TAG, photopath);
			        photopath =photopath.replace("\\", "");     //��б��ȡ������java��б�ܲ��ܵ�һд
			        Log.i(TAG, photopath);
			        showphoto.setImageUrl(photopath, R.drawable.abc_ab_share_pack_mtrl_alpha, R.drawable.abc_action_bar_item_background_material);
			        
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
	 
	
		 
	 }
	 
	


  
