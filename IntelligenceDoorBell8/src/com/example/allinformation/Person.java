package com.example.allinformation;

public class Person  {
      
	private String userName;     //�û������ֻ���
	private String deviceId;                //�豸���
	private String userNick;              //�û��ǳ�
	private String userPass;            //�û����������
	private String  userConpass;     //�û�ȷ������
	
	
	public Person(String userName, String deviceId, String userNick,
			String userPass, String userConpass) {
		
		this.userName = userName;
		this.deviceId = deviceId;
		this.userNick = userNick;
		this.userPass = userPass;
		this.userConpass = userConpass;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getUserConpass() {
		return userConpass;
	}


	public void setUserConpass(String userConpass) {
		this.userConpass = userConpass;
	}
	
	
	//public String toString(){
          
	//	return "[tel="+tel+",yanzheng="+yanzhengma+",nickname="+nickname+",password="+password+",confirmpassword="+confirmpassword+"]";
	//}
	
	
	
}
