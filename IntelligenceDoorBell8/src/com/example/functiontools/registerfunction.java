package com.example.functiontools;

import android.text.Editable;
import android.widget.EditText;
/**
 * 
 * @author lenovo //��õ�ǰҳ���EditText�ڵ�����
 *
 */
public class registerfunction {
          
	   
	   private static String info;
	   
	   public static String geteditinformation(EditText information){
		    
		   info = information.getText().toString();
		   return info;
		   
	   }
	  
	
	
}
