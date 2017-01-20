package com.inse.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.inse.dao.impl.UserLoginDaoImpl;
import com.inse.entity.UserLoginModel;
import com.inse.entity.WorkerModel;
import com.inse.service.UserLoginService;
import com.inse.services.impl.UserLoginServiceImpl;

@Path("/details")
@Component("userLogin")
public class UserLoginCtrl {

	
	
	@Autowired
	UserLoginService userLoginService ;

	
	

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	/*@GET
	@Path("/userLogin/{userid}/{password}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void verifyUserCredentials(@PathParam("userid") String user,@PathParam("password") String pass) {

		
		
	}*/
	
	
	@GET
	@Path("/verifyUser/{username}")
	@Produces(MediaType.APPLICATION_JSON )
	public Response verifyUserCredentials(@PathParam("username") String username) {

		UserLoginModel status = userLoginService.verifyUserCredentials(username);

		return Response.status(201).entity(status).build();
	}
}
