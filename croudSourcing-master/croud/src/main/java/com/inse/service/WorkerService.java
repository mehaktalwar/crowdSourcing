package com.inse.service;

import java.util.ArrayList;

import com.inse.entity.WorkerModel;

public interface WorkerService {

	WorkerModel getWorkerById(int catID);

	String createNewWorker(WorkerModel catdata);

	String upDateWorker(WorkerModel catdata);

	String deleteWorker(int catID);

	ArrayList<WorkerModel> getWorkerList();

	WorkerModel getWorkerByUserName(String username);

	ArrayList<WorkerModel> getWorkerListByCategory(String workerCat);



}
