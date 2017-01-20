package com.inse.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inse.dao.WorkerTaskDetailsDao;
import com.inse.entity.ClientModel;
import com.inse.entity.TaskModel;
import com.inse.entity.WorkerModel;
import com.inse.entity.WorkerTaskDetails;
import com.inse.service.ClientService;
import com.inse.service.TaskService;
import com.inse.service.WorkerService;
import com.inse.service.WorkerTaskDetailsService;

import javafx.concurrent.Worker;

@Service("workerTaskDetailsService")
public class WorkerTaskDetailsServiceImpl implements WorkerTaskDetailsService {

	@Autowired
	WorkerTaskDetailsDao workerTaskDetailsDao;

	@Autowired
	WorkerService workerService;

	@Autowired
	ClientService clientService;

	@Autowired
	TaskService taskService;

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setWorkerTaskDetailsDao(WorkerTaskDetailsDao workerTaskDetailsDao) {
		this.workerTaskDetailsDao = workerTaskDetailsDao;
	}

	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ArrayList<WorkerTaskDetails> getWorkerTaskDetailsById(int workerId) {
		ArrayList<WorkerTaskDetails> workerTaskDetails = workerTaskDetailsDao.getWorkerTaskDetailsById(workerId);
		return workerTaskDetails;
	}

	@Override
	public String addWorkerTaskDetails(WorkerTaskDetails catdata) {
		// TODO Auto-generated method stub
		catdata.setCreatedDate(new Date());
		catdata.setTaskStatus("PENDING");

		String status = workerTaskDetailsDao.addWorkerTaskDetails(catdata);
		return status;
	}

	@Override
	public String updateWorkerTaskDetails(WorkerTaskDetails taskDetails) {
		// TODO Auto-generated method stub
		String status = workerTaskDetailsDao.updateWorkerTaskDetails(taskDetails);
		return status;
	}

	@Override
	public String deleteWorkerTaskDetails(int workerTaskDetailsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WorkerTaskDetails> getPendingRequests(int workerId) {
		ArrayList<WorkerTaskDetails> status = workerTaskDetailsDao.getPendingRequests(workerId);
		return status;
	}

	@Override
	public String upDateWorkerPaymentDetails(int workerId, TaskModel taskModel) {

		// TODO Auto-generated method stub

		ArrayList<WorkerTaskDetails> workerTaskDetails = workerTaskDetailsDao.getWorkerTaskDetailsById(workerId,taskModel.getTaskpk());
		
		WorkerTaskDetails taskDetails = workerTaskDetails.get(0);
		taskDetails.setMoneyEarned(taskModel.getTaskPayment());
		taskDetails.setCredibility(taskModel.getTaskFeedback());
		taskDetails.setTaskStatus("CLOSED");

		String taskDetail = updateWorkerTaskDetails(taskDetails);

		return taskDetail;
	}

	@Override
	public String assignTask( WorkerTaskDetails workerTaskDetails) {
		
		//UPDATING DETAILS IN WORKER TABLE
		String result = updateWorkerTaskDetails(workerTaskDetails);
	
		// updating the status details in task
		// get taskby taskid
		TaskModel taskModel = taskService.getTaskByTaskID(workerTaskDetails.getTaskID());
		taskModel.setWorkerStatus("ASSIGNED");
		taskModel.setWorkerId(workerTaskDetails.getWorkerId());
		//taskModel.setWorkerStatus(workerTaskDetails.get);
		//workerTaskDetailsDao.updateWorkerTaskDetails(workerTaskDetails);

		// update task
		taskService.upDateTask(taskModel);

		return result;
	}

	@Override
	public ArrayList<WorkerTaskDetails> getWorkerCompletedTaskDetailsById(int workerId) {
		// TODO Auto-generated method stub
		ArrayList<WorkerTaskDetails> workerTaskDetails = workerTaskDetailsDao.getWorkerCompletedTaskDetailsById(workerId);
		return workerTaskDetails;
	}

}
