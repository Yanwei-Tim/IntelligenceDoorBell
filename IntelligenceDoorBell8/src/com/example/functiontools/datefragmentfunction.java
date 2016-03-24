package com.example.functiontools;

import java.io.File;
import java.io.IOException;
import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.view.SurfaceView;

public class datefragmentfunction {
   
   private static MediaRecorder  recorder;
   private static Boolean   isrecording;
    //��ʼ¼��Ƶ
   @SuppressLint("NewApi")
public  static  void   startluxiang(SurfaceView  ss) throws IllegalStateException, IOException{
	    
	    File file = new File("/sdcard/aaa.mp4");
	    if(file.exists() && file.length() > 0){
	    	file.delete();
	    }
	    recorder = new MediaRecorder();
	    recorder.setOrientationHint(90);
	   	recorder.reset();
	   	recorder.setAudioSource(MediaRecorder.AudioSource.MIC);   //������Ƶ¼��Դ
	   	recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA); //������Ƶ¼��Դ
	   	recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4); //����¼��ý��������ʽ
	   	recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT); //������Ƶ�ı����ʽ
	   	recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP); //������Ƶ�ı����ʽ
	   	recorder.setVideoFrameRate(6);                 //������Ƶ�Ĳ����ʣ�ÿ��5֡
	   	recorder.setOutputFile(file.getAbsolutePath());  //�����Ƶ�ļ���·��
	   	recorder.setPreviewDisplay(ss.getHolder().getSurface());                  //���ò�����Ƶͼ���Ԥ������
	   	recorder.prepare();
	   	recorder.start();
	  }
   //ֹͣ¼��Ƶ
   public static void stopluxiang(){
	    recorder.stop();
     	recorder.release();
     	recorder = null;
   }
  // ��ʼ¼��
  public  static void startluyin() throws IllegalStateException, IOException 
  {
	  File file = new File("/sdcard/luyin1.amr");
	    if(file.exists() && file.length() > 0){
	    	file.delete();   //��֤�ڴ���ֻ��һ�����ļ�
	    }
	     recorder = new MediaRecorder();
	     recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //������Ƶ¼��Դ
	     recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);  //������Ƶ�����ʽ
	     recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);    //������Ƶ�ı����ʽ
	     recorder.setOutputFile(file.getAbsolutePath());              //������Ƶ�ļ�����ļ�·��
         recorder.setOnErrorListener(new OnErrorListener(){

			@Override
			public void onError(MediaRecorder mr, int what, int extra) {
				// TODO Auto-egenerated method stub
				 //��������ֹͣ¼��
				recorder.stop();
				recorder.release();
				recorder = null;
				isrecording = false;
				return;
				
		    }
  	 
       });
       //׼������ʼ
       recorder.prepare();
       recorder.start();
       isrecording = true;
  }
  //ֹͣ¼��
    public static  void  stopluyin(){
	  //�������¼����ֹͣ���ͷ���Դ
      recorder.stop();
  	  recorder.release();	
  	  recorder = null;
  //	isrecording = false;
   }
    
    
    

}
   
	
	
	
	
	

