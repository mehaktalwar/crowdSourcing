package com.inse.dao;

import java.util.ArrayList;

import com.inse.entity.WorkerModel;

public interface WorkerDao {

	public WorkerModel getWorkerById(int catID) ;

	public String upDateWorker(WorkerModel catdata) ;

	public String deleteWorker(int catID);

	public String createNewWorker(WorkerModel catdata);

	public ArrayList<WorkerModel> getWorkerList();

	public WorkerModel getWorkerByUserName(String username);

	public ArrayList<WorkerModel> getWorkerListByCategory(String workerCat);

}
