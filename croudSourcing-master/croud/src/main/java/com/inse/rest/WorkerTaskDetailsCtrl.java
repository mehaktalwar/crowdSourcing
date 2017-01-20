package com.inse.rest;

import java.util.ArrayList;

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
import com.inse.entity.WorkerTaskDetails;
import com.inse.service.WorkerTaskDetailsService;

@Path("/workerTaskDetails")
@Component("workerTaskDetailsCtrl")
public class WorkerTaskDetailsCtrl {

	@Autowired
	WorkerTaskDetailsService workerTaskDetailsService;

	public void setWorkerTaskDetailsService(WorkerTaskDetailsService workerTaskDetailsService) {
		this.workerTaskDetailsService = workerTaskDetailsService;
	}

	
	//to fetch worker task
	@GET
	@Path("/id/{workerId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWorkerTaskDetailsById(@PathParam("workerId") int workerId) {

		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<>();
		workerTaskDetails = workerTaskDetailsService.getWorkerTaskDetailsById(workerId);
		return Response.status(201).entity(workerTaskDetails).build();

	}
	
	//to fetch worker task
	@GET
	@Path("/completed/id/{workerId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getWorkerCompletedTaskDetailsById(@PathParam("workerId") int workerId) {

		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<>();
		workerTaskDetails = workerTaskDetailsService.getWorkerCompletedTaskDetailsById(workerId);
		return Response.status(201).entity(workerTaskDetails).build();

	}

	//get pending requests for worker
	@GET
	@Path("/pendingReq/workerId/{workerId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPendingRequests(@PathParam("workerId") int workerId) {

		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<>();
		workerTaskDetails = workerTaskDetailsService.getPendingRequests(workerId);
		return Response.status(201).entity(workerTaskDetails).build();

	}

	@POST
	@Path("/assignTaskReq")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addWorkerTaskDetails(WorkerTaskDetails catdata) {

		String status = workerTaskDetailsService.addWorkerTaskDetails(catdata);

		return Response.status(201).entity(status).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorker(WorkerTaskDetails catdata) {

		String status = workerTaskDetailsService.updateWorkerTaskDetails(catdata);

		return Response.status(201).entity(status).build();
	}

	@DELETE
	@Path("/delete/id/{catID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWorkerById(@PathParam("catID") int workerTaskDetailsId) {

		String status = workerTaskDetailsService.deleteWorkerTaskDetails(workerTaskDetailsId);

		return Response.status(201).entity(status).build();
	}

	@PUT
	@Path("/payment/{workerId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorkerPaymentDetails(@PathParam("workerId") int workerId, TaskModel catdata) {

		String status = workerTaskDetailsService.upDateWorkerPaymentDetails(workerId, catdata);

		return Response.status(201).entity(status).build();
	}
	
	@POST
	@Path("/assignTask/workerId/{workerId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response acceptTaskReq( @PathParam("workerId") int workerId, WorkerTaskDetails catdata) {
		
		catdata.setWorkerId(workerId);

		String status = workerTaskDetailsService.assignTask(catdata);

		return Response.status(201).entity(status).build();
	}

}
