package com.inse.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inse.dao.TaskDao;
import com.inse.entity.TaskModel;
import com.inse.service.TaskService;
import com.inse.service.WorkerService;
import com.inse.service.WorkerTaskDetailsService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskDao;

	@Autowired
	WorkerTaskDetailsService taskDetailsService;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public void setTaskDetailsService(WorkerTaskDetailsService taskDetailsService) {
		this.taskDetailsService = taskDetailsService;
	}

	@Override
	public TaskModel getInitiatedTaskByClientID(int catID) {
		// TODO Auto-generated method stub
		ArrayList<TaskModel> taskmodels = taskDao.getInitiatedTaskByClientID(catID);
		if (taskmodels != null && !taskmodels.isEmpty()) {
			TaskModel taskModel = taskmodels.get(0);
			return taskModel;
		} else {
			return null;
		}

	}

	@Override
	public String upDateTask(TaskModel catdata) {
		// TODO Auto-generated method stub
		String status = taskDao.upDateTask(catdata);
		return status;
	}

	@Override
	public String deleteTask(int catID) {
		// TODO Auto-generated method stub
		String status = taskDao.deleteTask(catID);
		return status;
	}

	@Override
	public int createNewTask(TaskModel catdata) {
		int status = taskDao.createNewTask(catdata);
		return status;
	}

	@Override
	public ArrayList<TaskModel> getAllTasksByClientID(int catID) {
		ArrayList<TaskModel> status = taskDao.getAllTasksByClientID(catID);
		return status;
	}

	@Override
	public TaskModel getTaskByTaskID(int taskId) {
		// TODO Auto-generated method stub
		TaskModel taskmodel = taskDao.getTaskByTaskId(taskId);
		return taskmodel;

	}

	@Override
	public String sendTaskPayment(TaskModel taskdata) {
		// TODO Auto-generated method stub
		taskDetailsService.upDateWorkerPaymentDetails(taskdata.getWorkerId(), taskdata);
		taskdata.setTaskStatus("CLOSED");
		taskdata.setWorkerStatus("PAYMENT RECEIVED");
		upDateTask(taskdata);
		return "success";
	}

}
