package com.example.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
  /**
   * 
   * @author �����������������ת�����ַ���,�����ڴ���������������������ݷŵ�������У��ڴ�����������ݣ���ʾ����
   *
   */
public class streamtools    {
    
	 public static String readInputStream(InputStream is){
	  //ByteArrayOutputStream ���Ի�û����������ݣ���ת�����ֽ�����
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 int len = 0;
		 byte[] buffer = new byte[1024];
		 
		  try {
			while((len = is.read(buffer))!= -1){
				  baos.write(buffer,0,len);
			  }
			is.close();
			baos.close();
			byte[] result = baos.toByteArray();
			return new String(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	 }
	
}
