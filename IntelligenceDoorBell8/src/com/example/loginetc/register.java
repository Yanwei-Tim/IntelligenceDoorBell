package com.example.loginetc;



import java.io.IOException;

import org.apache.http.Header;
import org.json.JSONException;

import com.example.allinformation.Person;
import com.example.functiontools.registerfunction;
import com.example.http.httpservice;
import com.example.http.streamtools;
import com.example.jsontools.jsonservice;
import com.example.jsontools.jsontools;
import com.example.uiproject.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class register  extends Activity implements OnClickListener{
   
	  private static final String TAG = null;
	private Button switchphoto;
	  private ImageButton fanhuijiemian;
	  private EditText   tel0;
	  private EditText   yanzheng0;
	  private EditText  nickname0;
	  private EditText  password0;
	  private EditText confirmword0;
	  private TextView    ok;
	  private Person    changeperson;   //�����ֵ��person
	  private String   msg;             //json�ṹ���ַ���
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		switchphoto = (Button)findViewById(R.id.switchphoto);
		fanhuijiemian = (ImageButton)findViewById(R.id.fanhui);
		tel0 = (EditText)findViewById(R.id.tel);
		yanzheng0 = (EditText)findViewById(R.id.yanzheng);
		nickname0 = (EditText)findViewById(R.id.nickname);
		password0  = (EditText)findViewById(R.id.newpass);
		confirmword0 = (EditText)findViewById(R.id.confimpass);
        ok = (TextView)findViewById(R.id.ok);
		switchphoto.setOnClickListener(this);
		fanhuijiemian.setOnClickListener(this);
		ok.setOnClickListener(this);
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.switchphoto:
			 switchphoto.setBackgroundResource(R.drawable.yanzhengma);
			 break;
		case R.id.fanhui :
			 //������ǰ��activity
			 finish();
	         break;
		case R.id.ok :
			
			 if(TextUtils.isEmpty(tel0.getText()) || TextUtils.isEmpty(yanzheng0.getText()) ||TextUtils.isEmpty(nickname0.getText())
					  ||TextUtils.isEmpty(password0.getText()) ||TextUtils.isEmpty(confirmword0.getText()))
			 {
				 Toast.makeText(register.this, "�п������д", 0).show();;
				 
			 }
			
			 else{
			// new Thread(new network()).start();
			changeperson= jsonservice.getperson(registerfunction.geteditinformation(tel0), 
				       registerfunction.geteditinformation(yanzheng0),
				       registerfunction.geteditinformation(nickname0), 
				       registerfunction.geteditinformation(password0), 
				       registerfunction.geteditinformation(confirmword0));
		//����json�ַ���
			 try {
				msg = jsontools.createjsonstring("person", changeperson);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Log.i(TAG,msg);
			 //����json�ַ�������AsyncHttpClient�첽���
			 AsyncHttpClient client1  = new AsyncHttpClient();
			 String path1 = "http://192.168.1.111:8080/IntelligenceDoorBellWeb/chuanshu";
			 RequestParams params  = new RequestParams();
			 params.add("jsonstring", msg);
			 client1.post(path1, params,  new AsyncHttpResponseHandler(){

				@Override
				public void onSuccess(int statusCode, Header[] headers,
						byte[] responseBody) {
					// TODO Auto-generated method stub
					
					Toast.makeText(register.this,new String(responseBody) , 0).show();
					
				}
              //responsBody �Ƿ��������ص�����
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					// TODO Auto-generated method stub
					Toast.makeText(register.this, new String(responseBody), 0).show();
				}
				}) ;
		     break;
		/**
		 * ����
		 */
		} 
		}
	
		
	}
      
	
	
}