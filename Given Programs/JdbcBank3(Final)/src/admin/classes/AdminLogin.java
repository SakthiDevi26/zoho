package admin.classes;

import basics.GetDetails;
import admin.interfaces.AdminLoginInterface;
import bankconstants.BankConstants;

public class AdminLogin implements AdminLoginInterface {
	//connection
	public boolean adminLoginAccount() {
		GetDetails getdetails = new GetDetails();
		CheckAdminLogin checkadminlogin = new CheckAdminLogin();
		
		getdetails.getAdminLoginDetails();
		if(checkadminlogin.canAdminLogin(getdetails.adminUserName,getdetails.adminPassWord))
		{		
			return true;
		}
		return false;
	}
}
