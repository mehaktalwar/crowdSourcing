package com.inse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inse.dao.UserLoginDao;
import com.inse.dao.impl.UserLoginDaoImpl;
import com.inse.entity.UserLoginModel;
import com.inse.service.UserLoginService;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	UserLoginDao userLoginDao;
	
	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	@Override
	public String save(UserLoginModel userLoginModel) {
		// TODO Auto-generated method stub
		String status = userLoginDao.saveCredentials(userLoginModel);
		return status;
	}


	@Override
	public UserLoginModel verifyUserCredentials(String loginModel) {
		UserLoginModel status = userLoginDao.verifyUserCredentials(loginModel);
		if (status!=null) {
			return status;
		} else {
			status= new UserLoginModel();
			status.setIdentifier("not a user");
			return status;
		}
	}



	
	
	



}
