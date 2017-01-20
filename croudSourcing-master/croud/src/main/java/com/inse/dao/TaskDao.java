package com.inse.dao;

import java.util.ArrayList;

import com.inse.entity.TaskModel;

public interface TaskDao {

	ArrayList<TaskModel> getInitiatedTaskByClientID(int catID);

	
	String deleteTask(int catID);

	int createNewTask(TaskModel catdata);

	ArrayList<TaskModel> getAllTasksByClientID(int catID);

	TaskModel getTaskByTaskId(int taskId);

	String upDateTask(TaskModel taskModel);

}
