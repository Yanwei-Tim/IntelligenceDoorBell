package com.example.uiproject;

import java.io.IOException;
import java.util.zip.DataFormatException;

import com.example.functiontools.datefragmentfunction;
import com.example.uiassist.disappearshowui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class dateFragement   extends Fragment implements OnClickListener{
     
	    private Button takephoto;
	    private Button luzhivideo;
	    private Button talk;
	    private Button stopvedio;
	    private Button stopsound;
	    private SurfaceView surfaceview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//��õ�ǰ��fragment
		View datefragement = inflater.inflate(R.layout.date_layout, container, false);
		//��õ�ǰfragment�еĿؼ�
		luzhivideo = (Button) datefragement.findViewById(R.id.luxiang);
		takephoto = (Button) datefragement.findViewById(R.id.paizhao);
		talk = (Button)datefragement.findViewById(R.id.luyin);
		surfaceview = (SurfaceView)datefragement.findViewById(R.id.monitor);
		stopvedio = (Button)datefragement.findViewById(R.id.stopvedio);
		stopsound = (Button)datefragement.findViewById(R.id.stopsound);
		takephoto.setOnClickListener(this);
	    luzhivideo.setOnClickListener(this); 
	    talk.setOnClickListener(this);
	    stopvedio.setOnClickListener(this);
	    stopsound.setOnClickListener(this);
		return   datefragement;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.luxiang:
		     disappearshowui.disappear(luzhivideo);
			 disappearshowui.disappear(takephoto);
			 disappearshowui.disappear(talk);
			 disappearshowui.show(stopvedio);
			 try {
				    
				    datefragmentfunction.startluxiang(surfaceview);
				    Toast.makeText(getActivity(), "��ʼ¼����Ƶ", 0).show();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		
		
		case R.id.paizhao:
			 
			 break;
		
		
		
		case R.id.luyin:
			 disappearshowui.disappear(luzhivideo);
			 disappearshowui.disappear(takephoto);
			 disappearshowui.disappear(talk);
			 disappearshowui.show(stopsound);
			 try {
				   datefragmentfunction.startluyin();
				   Toast.makeText(getActivity(), "��ʼ¼����Ƶ", 0).show();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
			
		case R.id.stopvedio:
			 disappearshowui.show(luzhivideo);
			 disappearshowui.show(takephoto);
			 disappearshowui.show(talk);
			 disappearshowui.disappear(stopvedio);
			 datefragmentfunction.stopluxiang();
			 Toast.makeText(getActivity(), "¼�����������¼��", 0).show();
			 break;
			 
			 
		case R.id.stopsound:
			 disappearshowui.show(luzhivideo);
			 disappearshowui.show(takephoto);
			 disappearshowui.show(talk);
			 disappearshowui.disappear(stopsound);
			 datefragmentfunction.stopluyin();
			 Toast.makeText(getActivity(), "¼������,����¼��", 0).show();;
			 break;
		}
	}
  
	  
	
	
}
