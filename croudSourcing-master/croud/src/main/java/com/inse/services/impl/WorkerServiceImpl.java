package com.inse.services.impl;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inse.dao.WorkerDao;
import com.inse.entity.UserLoginModel;
import com.inse.entity.WorkerModel;
import com.inse.entity.WorkerTaskDetails;
import com.inse.service.UserLoginService;
import com.inse.service.WorkerService;
import com.inse.service.WorkerTaskDetailsService;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerDao workerDao;

	@Autowired
	UserLoginService loginService;

	@Autowired
	WorkerTaskDetailsService workerTaskDetailsService;

	public void setLoginService(UserLoginService loginService) {
		this.loginService = loginService;
	}

	public void setWorkerDao(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}

	public WorkerTaskDetailsService getWorkerTaskDetailsService() {
		return workerTaskDetailsService;
	}

	public void setWorkerTaskDetailsService(WorkerTaskDetailsService workerTaskDetailsService) {
		this.workerTaskDetailsService = workerTaskDetailsService;
	}

	@Override
	public WorkerModel getWorkerById(int catID) {
		// TODO Auto-generated method stub

		WorkerModel workerModel = workerDao.getWorkerById(catID);
		workerModel = workerExtraDetails(workerModel);
		return workerModel;
	}

	@Override
	public String deleteWorker(int catID) {
		// TODO Auto-generated method stub
		String status = workerDao.deleteWorker(catID);
		return status;
	}

	@Override
	public String createNewWorker(WorkerModel catdata) {

		UserLoginModel userLoginModel = new UserLoginModel();
		userLoginModel.setUsername(catdata.getWorkerEmail());
		userLoginModel.setPassword(catdata.getWorkerPassword());
		userLoginModel.setIdentifier("worker");
		Date sysDate = new Date();
		userLoginModel.setCreatedDate(sysDate);

		String statusLogin = loginService.save(userLoginModel);
		String status = workerDao.createNewWorker(catdata);

		return status;
	}

	@Override
	public ArrayList<WorkerModel> getWorkerList() {
		ArrayList<WorkerModel> workerLst = workerDao.getWorkerList();
		return workerLst;
	}

	@Override
	public WorkerModel getWorkerByUserName(String username) {
		WorkerModel workerModel = workerDao.getWorkerByUserName(username);

		workerModel = workerExtraDetails(workerModel);

		return workerModel;

	}

	public WorkerModel workerExtraDetails(WorkerModel workerModel) {
		// get worker det
		ArrayList<WorkerTaskDetails> taskDetailsLst = workerTaskDetailsService
				.getWorkerCompletedTaskDetailsById(workerModel.getPkWorker());

		// crediblity,
		double crediblity = 0.0;
		double moneyEarned = 0;
		int experince = 0;

		for (WorkerTaskDetails workerTaskDetails : taskDetailsLst) {
			experince++;
			crediblity += workerTaskDetails.getCredibility();
			moneyEarned += workerTaskDetails.getMoneyEarned();
		}
		if (experince >= 1) {
			workerModel.setCrediblity(crediblity / experince);
		}
		workerModel.setTotalMoneyEarned(moneyEarned);
		workerModel.setExperince(experince);
		// update worker data with experince
		upDateWorker(workerModel);
		return workerModel;
	}

	@Override
	public ArrayList<WorkerModel> getWorkerListByCategory(String workerCat) {
		// TODO Auto-generated method stub
		ArrayList<WorkerModel> workerLst = workerDao.getWorkerListByCategory(workerCat);
		return workerLst;
	}

	@Override
	public String upDateWorker(WorkerModel catdata) {
		// TODO Auto-generated method stub
		String status = workerDao.upDateWorker(catdata);
		return status;
	}

}
