package com.inse.dao.impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inse.dao.WorkerTaskDetailsDao;
import com.inse.entity.TaskModel;
import com.inse.entity.WorkerTaskDetails;
import com.inse.util.CustomHibernateDaoSupport;

@Repository("workerTaskDetailsDao")
public class WorkerTaskDetailsDaoImpl extends CustomHibernateDaoSupport implements WorkerTaskDetailsDao {

	@Override
	public String addWorkerTaskDetails(WorkerTaskDetails catdata) {
		// TODO Auto-generated method stub

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ArrayList<WorkerTaskDetails> getWorkerTaskDetailsById(int workerId) {
		// TODO Auto-generated method stub
		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<WorkerTaskDetails>();

		workerTaskDetails = (ArrayList<WorkerTaskDetails>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(WorkerTaskDetails.class).add(Restrictions.eq("workerId", workerId)));
		return workerTaskDetails;
	}

	@Override
	public ArrayList<WorkerTaskDetails> getPendingRequests(int workerId) {
		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<WorkerTaskDetails>();
		workerTaskDetails = (ArrayList<WorkerTaskDetails>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(WorkerTaskDetails.class)
						.add(Restrictions.eq("workerId", workerId)).add(Restrictions.ne("taskStatus", "CLOSED")));
		return workerTaskDetails;
	}

	// updating the worker task details
	@Override
	public String updateWorkerTaskDetails(WorkerTaskDetails taskDetails) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(taskDetails);
		return "success";
	}

	@Override
	public ArrayList<WorkerTaskDetails> getWorkerTaskDetailsById(int workerId, int taskpk) {
		// TODO Auto-generated method stub
		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<WorkerTaskDetails>();

		workerTaskDetails = (ArrayList<WorkerTaskDetails>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(WorkerTaskDetails.class).add(Restrictions.eq("workerId", workerId)).add(Restrictions.eq("taskID", taskpk)));
		return workerTaskDetails;
	}

	@Override
	public ArrayList<WorkerTaskDetails> getWorkerCompletedTaskDetailsById(int workerId) {
		// TODO Auto-generated method stub
		ArrayList<WorkerTaskDetails> workerTaskDetails = new ArrayList<WorkerTaskDetails>();
		workerTaskDetails = (ArrayList<WorkerTaskDetails>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(WorkerTaskDetails.class)
						.add(Restrictions.eq("workerId", workerId)).add(Restrictions.eq("taskStatus", "CLOSED")));
		return workerTaskDetails;
	}

}
