package com.inse.rest;

import java.util.ArrayList;
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

import com.inse.entity.TaskModel;
import com.inse.entity.WorkerModel;
import com.inse.service.WorkerService;

@Path("/worker")
@Component("workerCtrl")
public class WorkerCtrl {

	@Autowired
	WorkerService workerService;

	
	public void setworkerService(WorkerService workerService) {
		this.workerService = workerService;
	}

	@GET
	@Path("/id/{catID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWorkerById(@PathParam("catID") int catID) {

		WorkerModel workerModel = workerService.getWorkerById(catID);
		return Response.status(201).entity(workerModel).build();

	}
	
	@GET
	@Path("/username/{username}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWorkerByUserName(@PathParam("username") String username) {

		WorkerModel workerModel = workerService.getWorkerByUserName(username);
		return Response.status(201).entity(workerModel).build();

	}
	
	
	@GET
	@Path("/workerLst")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWorkerList(){

		ArrayList<WorkerModel> workerModelLst = workerService.getWorkerList();
		return Response.status(201).entity(workerModelLst).build();

	}
	
	@GET
	@Path("/workerLstbyCat/{workerCat}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWorkerListByCategory(@PathParam("workerCat") String workerCat){

		ArrayList<WorkerModel> workerModelLst = workerService.getWorkerListByCategory(workerCat);
		return Response.status(201).entity(workerModelLst).build();

	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON )
	public Response createNewWorker(WorkerModel catdata) {
		catdata.setCreatedDate(new Date() );
		String status = workerService.createNewWorker(catdata);

		return Response.status(201).entity(status).build();
	}
	


	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorker(WorkerModel catdata) {

		String status = workerService.upDateWorker(catdata);

		return Response.status(201).entity(status).build();
	}

	@DELETE
	@Path("/delete/id/{catID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWorkerById(@PathParam("catID") int workerId) {

		String status = workerService.deleteWorker(workerId);

		return Response.status(201).entity(status).build();
	}

}
