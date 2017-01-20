package com.inse.service;

import java.util.ArrayList;

import com.inse.entity.TaskModel;
import com.inse.entity.WorkerTaskDetails;

public interface WorkerTaskDetailsService {

	ArrayList<WorkerTaskDetails> getWorkerTaskDetailsById(int catID);

	String addWorkerTaskDetails(WorkerTaskDetails catdata);

	String deleteWorkerTaskDetails(int workerTaskDetailsId);

	ArrayList<WorkerTaskDetails> getPendingRequests(int workerId);
	
	String upDateWorkerPaymentDetails(int workerId, TaskModel catdata);

	String updateWorkerTaskDetails(WorkerTaskDetails taskDetails);

	String assignTask(WorkerTaskDetails catdata);

	ArrayList<WorkerTaskDetails> getWorkerCompletedTaskDetailsById(int workerId);

}
