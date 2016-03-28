package com.example.loginetc;



import org.apache.http.Header;
import org.json.JSONException;

import android.app.Activity;
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

import com.example.allinformation.forgetinfo;
import com.example.functiontools.registerfunction;
import com.example.jsontools.jsontools;
import com.example.uiproject.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


    

	       
public class forget  extends Activity implements OnClickListener{
    
	   private static final String TAG = null;
	private ImageButton fanhuijiemian;   //���ذ�ť
	   private   Button   getcode;     //��֤��
	   private    TextView  ok  ;       //ȷ��
	   private     EditText    tel;   //�ֻ�����
	   private  EditText    checkma  ;   //��֤��
	   private  String   telephone ;
	   private  String messagema;
	   private   String msg;  //��װ���ַ���
	   
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_layout);
		
		 fanhuijiemian = (ImageButton)findViewById(R.id.fanhui);
		 getcode  = (Button)findViewById(R.id.getCode);
		 ok = (TextView)findViewById(R.id.forgetmima);
		 tel = (EditText)findViewById(R.id.tel);
		 checkma = (EditText)findViewById(R.id.checkma);
		
		 messagema = checkma.getText().toString();
		 getcode.setOnClickListener(this);
		 ok.setOnClickListener(this);
		 fanhuijiemian.setOnClickListener(this);
		 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fanhui:
			 finish();
			 break;
		case  R.id.forgetmima:
			   if(TextUtils.isEmpty(tel.getText()) || TextUtils.isEmpty(checkma.getText())){
				         Toast.makeText(getApplicationContext(), "�п���,��������",0).show();
			   }
			   else{
				       //   telephone = tel.getText().toString();
				        //  messagema = checkma.getText().toString();
				          //��װjson�ַ���
				    forgetinfo   findmima = new forgetinfo(registerfunction.geteditinformation(tel), registerfunction.geteditinformation(checkma)) ;
				    try {
						msg = jsontools.createjsonfind(findmima);
						Log.i(TAG, msg);
						AsyncHttpClient   client = new AsyncHttpClient();
						String path1 = "http://219.244.48.159:8080/WeChat/sendPassSmartDogAction.action";
						RequestParams   params = new RequestParams();
						params.add("find", msg);
						client.post(path1, params,new AsyncHttpResponseHandler() {
							
							@Override
							public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
								// TODO Auto-generated method stub
								String data  = new String(responseBody);
								data = data.substring(8, 15);
								if(data.equals("success"))
						       Toast.makeText(getApplicationContext(), "����Ҳ�����������ֻ�", 0).show();
							}
							
							@Override
							public void onFailure(int statusCode, Header[] headers,
									byte[] responseBody, Throwable error) {
								// TODO Auto-generated method stub
						        String  data = new String(responseBody);
						         data = data.substring(8, 12);
						         if(data.equals("fail"))
						         Toast.makeText(getApplicationContext(), "���뷢��ʧ��", 0).show();  
							}
						});
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				          
			   }
			      break;
		case  R.id.getCode:
			       telephone = tel.getText().toString();
			   //     Toast.makeText(getApplicationContext(), "������֤���ѷ�������ֻ�,����д", 0).show();
			        //������������ֻ�����
			        //����json�ַ�������AsyncHttpClient�첽���
					 AsyncHttpClient client1  = new AsyncHttpClient();
					 String path1 = "http://219.244.48.159:8080/WeChat/sendCodeSmartDogAction.action";
					 RequestParams params  = new RequestParams();
					 params.add("tel", telephone);
					 client1.post(path1, params,  new AsyncHttpResponseHandler(){
                   
						@Override
						public void onSuccess(int statusCode, Header[] headers,
								byte[] responseBody) {
							// TODO Auto-generated method stub
							//String returninfo = responseBody.toString();
						//	String  jiequinfo = returninfo.substring(0,3);
							String   data = new String(responseBody);
							if(data.equals("success")){
						      	Toast.makeText(forget.this,"��֤���ѷ����������ֻ�" , 0).show();
							}
							else{
								 Toast.makeText(forget.this, "��֤���ѷ����������ֻ�", 0).show();
							}
						}
		              //responsBody �Ƿ��������ص�����
						@Override
						public void onFailure(int statusCode, Header[] headers,
								byte[] responseBody, Throwable error) {
							// TODO Auto-generated method stub
							Toast.makeText(forget.this, new String(responseBody), 0).show();
						}
						}) ; 
			       break;
		}
	}
    
	       
	
	
	
}

	
	

