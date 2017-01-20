package com.inse.rest;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inse.entity.ClientModel;
import com.inse.service.ClientService;

@Path("/client")
@Component("clientCtrl")
public class ClientCtrl {

	@Autowired
	ClientService clientService;



	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@GET
	@Path("/id/{catID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClientById(@PathParam("catID") int catID) {

		ClientModel status = clientService.getClientById(catID);
		return Response.status(201).entity(status).build();

	}
	
	@GET
	@Path("/username/{username}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClientByUserName(@PathParam("username") String username) {

		ClientModel status = clientService.getClientByUserName(username);
		return Response.status(201).entity(status).build();

	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON )
	public Response createNewClient(ClientModel catdata) {
		catdata.setCreatedDate(new Date() );
		String status = clientService.createNewClient(catdata);

		return Response.status(201).entity(status).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateClient(String catdata) {

		String status = clientService.upDateClient(catdata);

		return Response.status(201).entity(status).build();
	}

	@DELETE
	@Path("/delete/id/{catID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteClientById(@PathParam("catID") int catID) {

		String status = clientService.deleteClient(catID);

		return Response.status(201).entity(status).build();
	}

}
