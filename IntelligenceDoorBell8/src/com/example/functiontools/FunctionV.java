package com.example.functiontools;

import java.io.File;



import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Environment;
import android.util.Log;
import android.widget.VideoView;

/**
 * ���ŷ���������Ƶ�ļ�
 * @author jsjxy
 *
 */
public class FunctionV implements OnPreparedListener {

	       private   int  bofang = 0;   //���ű�־
	       private  VideoView   show;
	       
	       public    FunctionV(){
	    	   
	       }
	       
	       public  void start(VideoView showmv ,String path){
			    if(this.bofang == 0){
			    
			    //    /showmv.setVideoPath("/sdcard/Wiz Khalifa-See you again.mp4");
			      showmv.setVideoPath(path); //���ñ�����Դ·��
				  showmv.requestFocus();    //���ý���
				   this.bofang = 1 ;
			    }
			     showmv.setOnPreparedListener(this);
			     showmv.start();
			     
		  }
			   
		 
		  public   void pause(VideoView showmv){
			
			  if(showmv != null && showmv.isPlaying()){
				showmv.pause();
				this.bofang = 2;
			 }
		  }
		@Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			  
		}
	
	
	
}
