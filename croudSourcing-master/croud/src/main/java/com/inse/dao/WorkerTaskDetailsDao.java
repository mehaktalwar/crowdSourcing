package com.inse.dao;

import java.util.ArrayList;

import com.inse.entity.WorkerTaskDetails;

public interface WorkerTaskDetailsDao {

	String addWorkerTaskDetails(WorkerTaskDetails catdata);

	ArrayList<WorkerTaskDetails> getWorkerTaskDetailsById(int workerId);

	ArrayList<WorkerTaskDetails> getPendingRequests(int workerId);

	String updateWorkerTaskDetails(WorkerTaskDetails taskDetails);

	ArrayList<WorkerTaskDetails> getWorkerTaskDetailsById(int workerId, int taskpk);

	ArrayList<WorkerTaskDetails> getWorkerCompletedTaskDetailsById(int workerId);

}
