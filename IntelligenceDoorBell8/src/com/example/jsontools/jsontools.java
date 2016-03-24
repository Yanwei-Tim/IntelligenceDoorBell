package com.example.jsontools;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.allinformation.Audioinfo;
import com.example.allinformation.Person;
import com.example.allinformation.enter;
import com.example.allinformation.forgetinfo;
import com.example.allinformation.getJsonResult;

/**
 * ��װjson��Ϣ
 * @author lenovo
 *
 */
  
  

public class jsontools {
         //��װע����Ϣ����װjson  
	     public static String createjsonzhuce(Person person) throws JSONException{
			
	    	 String fengzhuan;
	    	 JSONObject  jsonobject = new JSONObject();
	    	 JSONArray  jsonarray = new JSONArray();
	    	 JSONObject   fengzhuang = new JSONObject();
	    	 fengzhuang.put("userName", person.getUserName());
	    	 fengzhuang.put("deviceId", person.getDeviceId());
	    	 fengzhuang.put("userNick", person.getUserNick());
	    	 fengzhuang.put("userPass", person.getUserPass());
	    	 jsonarray.put(fengzhuang);
	    	  jsonobject.put("Data", jsonarray);
	    	  fengzhuan = jsonobject.toString();
	    	  return fengzhuan;
		   }
	     //��װ��½��Ϣ����װjson  
	     public  static  String createjsondenglu(enter    enter1) throws JSONException{
	    	    String     denglu  ;
	    	    JSONObject   jsonobject  = new JSONObject();
	    	    JSONArray   jsonarray = new JSONArray();
	    	    JSONObject    dengluinfo= new JSONObject();
	    	    dengluinfo.put("userName",enter1.getUserName());
	    	    dengluinfo.put("userPass", enter1.getUserPass());
	    	    jsonarray.put(dengluinfo);
	    	    jsonobject.put("Data", jsonarray);
	    	    denglu = jsonobject.toString();
	    	    return denglu;
	    	 
	     }
	     //��װ�һ�������Ϣ����װjson  
	     public static String   createjsonfind(forgetinfo info) throws JSONException{
	    	      
	    	   String findmima;
	    	   JSONObject  jsonobject =new JSONObject();
	    	   JSONArray  array  = new JSONArray();
	    	   JSONObject   findinfo = new JSONObject();
	    	   findinfo.put("phone", info.getPhone());
	    	   findinfo.put("checkma", info.getCheckma());
	    	   array.put(findinfo);
	    	   jsonobject.put("Data", array);
	    	   findmima = jsonobject.toString();
	    	   return    findmima;
	    }
	     //ʹ��JSON������json
	       public  static  getJsonResult  jiexienter(String jsonstring) throws JSONException{
	    	    
	    	            getJsonResult   getreslut = new getJsonResult();
	    	            JSONObject  jsonobject = new JSONObject(jsonstring); //����Ѿ���װ�õ�һ�����ַ���
	    	           //���عؼ���key����Ӧ��json�ַ���
	    	            JSONObject   jsonresult = jsonobject.getJSONObject("msg");  //�õ��ؼ�������Ӧ��value
	    	            getreslut.setUserNick(jsonresult.getString("userNick"));
	    	            return  getreslut;
	    	    	
	       }
	     
	       //����json����
	   	public  static  List<Audioinfo> getListperson(String key,String jsonstring) throws Exception{
	   		          
	   		     List<Audioinfo> list = new ArrayList<Audioinfo>();
	   		     JSONObject jsonobject = new JSONObject(jsonstring);
	   		     //���عؼ���key����Ӧ��json����
	   		     JSONArray jsonarrty = jsonobject.getJSONArray(key);  
	   		     for(int i = 0;i < jsonarrty.length(); i++){
	   		    	 JSONObject   jsonobject2 =  jsonarrty.getJSONObject(i);      //json�������ж��json����
	   		    	Audioinfo person1 = new Audioinfo();
	   		    //	 person1.setId(jsonobject2.getInt("id"));
	   		 //   	 person1.setName(jsonobject2.getString("name"));
	   			//	 person1.setAddress(jsonobject2.getString("address"));
	   				 list.add(person1);
	   		     }
	   		return list;
	   	}
	     
	     
	     
	     
	     
	     
	     
}