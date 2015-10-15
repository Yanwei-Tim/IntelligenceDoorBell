package com.example.uiproject;

import com.example.segmentcontrolview.Onsegmentlistenerclicker;
import com.example.segmentcontrolview.SegmentView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
// android-support-v4 ֻ����һ����������֪�������ĸ�
public class mainactivity extends  SlidingFragmentActivity    implements OnClickListener, Onsegmentlistenerclicker{
      /*----����չʾ��̬��fragment*/
	  private dateFragement showdate;
	  private findFragment  showfind;
	  private setupFragment showsetup;
	  private messageFragment showmessage;
	  
	  /*-------���ڵĽ��沼��  ---------*/
      private View  datelayout;
      private View  findlayout;
      private View setupolayout;
      private View messagelayout;
	  
      private ImageView  one1;
      private ImageView  two1;
      private ImageView  three1;
      private ImageView  four1;
      private TextView   one;
      private TextView   two;
      private TextView   three;
      private TextView   four;      
      
      private SegmentView  view1 = null;
      
      
      private FragmentManager frangementmanager; //���ڶ�fragement����
      
	  //��ò໬�˵�
      private SlidingMenu sm;
      
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.cehua);
		setContentView(R.layout.activity_main);
      	frangementmanager =   getSupportFragmentManager() ;
		initcehua();
      	init();
		setTabSelection(0);
	
		
	}
	public void initcehua(){
		
		sm = getSlidingMenu();  //��ȡ�໬�˵�
		sm.setMode(SlidingMenu.LEFT);  //�����󻬲˵�
		//sm.setAboveOffsetRes(R.dimen.shdow_width);   
		sm.setBehindOffsetRes(R.dimen.sliding_menuoffset);     //����ҳʣ��Ŀ���
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	//	sm.setShadowWidthRes(R.dimen.shadow_width);
		//������Ӱ
	   //	sm.setShadowWidth(R.dimen.shadow_width	);
		
		
		
	}
	public void init(){
		datelayout = findViewById(R.id.date);
		findlayout = findViewById(R.id.find);
		setupolayout = findViewById(R.id.set);
		messagelayout = findViewById(R.id.message);
		one = (TextView)findViewById(R.id.datezi);
		two = (TextView)findViewById(R.id.findzi);
		three = (TextView)findViewById(R.id.setzi);
		four = (TextView)findViewById(R.id.messagezi);
		one1 =(ImageView)findViewById(R.id.datephoto);
		two1 =(ImageView)findViewById(R.id.findphoto);
		three1 = (ImageView)findViewById(R.id.setphoto);
		four1 = (ImageView)findViewById(R.id.messagephoto);
		
		datelayout.setOnClickListener(this);
		findlayout.setOnClickListener(this);
		setupolayout.setOnClickListener(this);
		messagelayout.setOnClickListener(this);
		
	}
	
	
	public void  setTabSelection(int index){
		
	  FragmentTransaction trans = frangementmanager.beginTransaction();
	  clearselection();
	  hideFragements(trans);
	  //��ʾ��̬����
	  switch (index) {
	   case  0:
		   one.setTextColor(Color.GREEN);
		   one1.setImageResource(R.drawable.date1);;
		if(showdate == null){
			showdate = new dateFragement();
			trans.add(R.id.content, showdate);
		}
		else
		{
			trans.show(showdate);
		}
		trans.commit();
		break;
    
	   case 1:
		   two.setTextColor(Color.GREEN);
		   two1.setImageResource(R.drawable.find1);
		   if(showfind == null){
				showfind = new findFragment();
				trans.add(R.id.content, showfind);
			}
			else
			{
				trans.show(showfind);
			}
		   trans.commit();
			break;
	   case  2:
		   three.setTextColor(Color.GREEN);
		   three1.setImageResource(R.drawable.set1);
			if(showsetup == null){
				showsetup = new setupFragment();
				trans.add(R.id.content, showsetup);
			}
			else
			{
				trans.show(showsetup);
			}
			trans.commit();
			break;
	   case 3 :
		   four.setTextColor(Color.GREEN);
		   four1.setImageResource(R.drawable.message);
		   if(showmessage == null){
			   showmessage = new messageFragment();
			   trans.add(R.id.content, showmessage);
		   }
		   else{
			 trans.show(showmessage);
		   }
	       trans.commit();
	       break;
		   
	}
		
		
		
		
		
	}
	//��������е�ѡ��״̬
	public void clearselection(){
		one.setTextColor(Color.WHITE);
		two.setTextColor(Color.WHITE);
		three.setTextColor(Color.WHITE);
		four.setTextColor(Color.WHITE);
		one1.setImageResource(R.drawable.date);
		two1.setImageResource(R.drawable.find);
		three1.setImageResource(R.drawable.set);
		four1.setImageResource(R.drawable.message1);
		
	}
	//������fragement ��������״̬
	
	public void hideFragements(FragmentTransaction transaction){
		if (showdate != null) {  
            transaction.hide(showdate);  
        }  
        if (showfind != null) {  
            transaction.hide(showfind);  
        }  
        if (showsetup != null) {  
            transaction.hide(showsetup);  
        }  
        if(showmessage != null){
        	transaction.hide(showmessage);  
        }
       
	}
	@Override
	public void onClick(View  v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.date:
			 setTabSelection(0);
			 break;
		case R.id.find:
			 setTabSelection(1);
			 break;
		case R.id.set:
			 setTabSelection(2);
			 break;
		case R.id.message:
			setTabSelection(3);
			break;
	    }
		
	}
	@Override
	public void setOnsegment(View v, int position) {
		// TODO Auto-generated method stub
		  switch (position) {
		case 0:
			Toast.makeText(this, "dsfsdf", 0).show();;
			break;
		case 1: 
			Toast.makeText(this, "sdfsdfdf", 0).show();;
		case 2:
			 Toast.makeText(this, "sdfdfdsfsdf", 0).show();
			 break;
		default:
			break;
		}
	}

	
}