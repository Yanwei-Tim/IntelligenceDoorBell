package com.example.jsontools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.allinformation.Person;

/**
 * ��װjson��Ϣ
 * @author lenovo
 *
 */
  
  

public class jsontools {
         //��װע����Ϣ  
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
	     //��װ��½��Ϣ
	     public  static  String createjsondenglu(){
	    	 
	    	 return null;
	     }
	     //��װ�һ�������Ϣ
	     public static String   createjsonfind(){
	    	 
	    	 return null;
	     }
}
