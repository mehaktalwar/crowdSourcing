package com.inse.dao;

import com.inse.entity.UserLoginModel;

public interface UserLoginDao {


	String saveCredentials(UserLoginModel userLogin);

	UserLoginModel verifyUserCredentials(String loginModel);

}
