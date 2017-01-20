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

import com.inse.entity.ClientModel;
import com.inse.entity.TaskModel;
import com.inse.service.ClientService;
import com.inse.service.TaskService;

@Path("/task")
@Component("taskCtrl")
public class TaskCtrl {

	@Autowired
	TaskService taskService;

	@Autowired
	ClientService clientService;

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@GET
	@Path("/taskId/{taskId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTaskByTaskId(@PathParam("taskId") int taskId) {

		TaskModel status = taskService.getTaskByTaskID(taskId);
		return Response.status(201).entity(status).build();

	}
	
	@GET
	@Path("/initiatedTask/{clientID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTaskInitiatedClientID(@PathParam("clientID") int clientID) {

		TaskModel status = taskService.getInitiatedTaskByClientID(clientID);
		return Response.status(201).entity(status).build();

	}


	@GET
	@Path("/clientId/{client}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTasksByClientID(@PathParam("client") int client) {

		ArrayList<TaskModel> taskLst = taskService.getAllTasksByClientID(client);
		return Response.status(201).entity(taskLst).build();

	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewTask(TaskModel catdata) {

		ClientModel clientModel = new ClientModel();
		clientModel = clientService.getClientByUserName(catdata.getClientUsername());
		catdata.setClient(clientModel);
		catdata.setTaskStatus("INITIATED");
		catdata.setCreatedDate(new Date());
		int status = taskService.createNewTask(catdata);

		return Response.status(201).entity(status).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTask(TaskModel catdata) {

		String status = taskService.upDateTask(catdata);

		return Response.status(201).entity(status).build();
	}

	@DELETE
	@Path("/delete/id/{catID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTaskById(@PathParam("catID") int catID) {

		String status = taskService.deleteTask(catID);

		return Response.status(201).entity(status).build();
	}

	@Deprecated
	@GET
	@Path("/taskID/{taskId}/taskDetailId/{workerID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response allocateWorkerToTask() {
		return null;

	}
	
	@POST
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendTaskPayment(TaskModel taskdata) {

		String status = taskService.sendTaskPayment(taskdata);

		return Response.status(201).entity(status).build();
	}

}
