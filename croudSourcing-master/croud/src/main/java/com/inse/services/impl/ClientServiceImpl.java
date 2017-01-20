package com.inse.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inse.dao.ClientDao;
import com.inse.entity.ClientModel;
import com.inse.entity.UserLoginModel;
import com.inse.service.ClientService;
import com.inse.service.UserLoginService;

@Service("clientService")
public class ClientServiceImpl  implements ClientService{

	
	@Autowired
	ClientDao clientDao;
	

	@Autowired
	UserLoginService loginService;
	

	
	public void setLoginService(UserLoginService loginService) {
		this.loginService = loginService;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}



	@Override
	public ClientModel getClientById(int catID) {
		// TODO Auto-generated method stub
		
		ClientModel status=clientDao.getClientById(catID);
		return status;
	}



	@Override
	public String upDateClient(String catdata) {
		// TODO Auto-generated method stub
		String status=clientDao. upDateClient( catdata);
		return status;
	}

	@Override
	public String deleteClient(int catID) {
		// TODO Auto-generated method stub
		String status=clientDao.deleteClient( catID);
		return status;
	}

	@Override
	public String createNewClient(ClientModel catdata) {
		
		UserLoginModel userLoginModel= new UserLoginModel();
		userLoginModel.setUsername(catdata.getClientEmail());
		userLoginModel.setPassword(catdata.getPassword());
		userLoginModel.setIdentifier("client");
		userLoginModel.setCreatedDate( new Date());
		
		 String statusLogin=loginService.save(userLoginModel);
		String status=clientDao.createNewClient( catdata);
		return status;
	}

	@Override
	public ClientModel getClientByUserName(String username) {
		// TODO Auto-generated method stub
		ClientModel status=clientDao.getClientByUserName(username);
		return status;
	}


}
