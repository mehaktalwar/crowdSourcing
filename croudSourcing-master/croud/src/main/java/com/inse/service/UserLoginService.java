package com.inse.service;

import com.inse.entity.UserLoginModel;

public interface UserLoginService {



	String save(UserLoginModel userLoginModel);

	UserLoginModel verifyUserCredentials(String username);
	
	
	

}
