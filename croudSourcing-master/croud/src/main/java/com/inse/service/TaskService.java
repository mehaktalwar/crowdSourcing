package com.inse.service;

import java.util.ArrayList;

import com.inse.entity.TaskModel;

public interface TaskService {

	TaskModel getInitiatedTaskByClientID(int catID);

	int createNewTask(TaskModel catdata);

	String deleteTask(int catID);

	ArrayList<TaskModel> getAllTasksByClientID(int catID);

	TaskModel getTaskByTaskID(int taskId);

	String upDateTask(TaskModel catdata);

	String sendTaskPayment(TaskModel taskdata);


}
