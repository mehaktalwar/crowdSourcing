package com.inse.dao.impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.inse.dao.WorkerDao;
import com.inse.entity.WorkerModel;
import com.inse.entity.WorkerTaskDetails;
import com.inse.util.CustomHibernateDaoSupport;

@Repository("workerDaoImpl")
public class WorkerDaoImpl extends CustomHibernateDaoSupport implements WorkerDao {

	@Override
	public WorkerModel getWorkerById(int catID) {
		// TODO Auto-generated method stub

		WorkerModel workerModel = getHibernateTemplate().get(WorkerModel.class, catID);
		// System.out.println(workerModel.getWorkerTaskDetails());
		return workerModel;
	}

	@Override
	public String deleteWorker(int catID) {
		// TODO Auto-generated method stub
		return null;
	}

	public String createNewWorker1(WorkerTaskDetails catdata) {
		// TODO Auto-generated method stub

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		getHibernateTemplate().update(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public String createNewWorker(WorkerModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		return "success";
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<WorkerModel> getWorkerList() {
		ArrayList<WorkerModel> workerDetailsLst = new ArrayList<WorkerModel>();
		workerDetailsLst = (ArrayList<WorkerModel>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(WorkerModel.class).add(Restrictions.eq("availabilityFlag", true)));
		return workerDetailsLst;
	}

	@Override
	public WorkerModel getWorkerByUserName(String username) {
		// TODO Auto-generated method stub
		ArrayList<WorkerModel> workerDetailsLst = new ArrayList<WorkerModel>();
		workerDetailsLst = (ArrayList<WorkerModel>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(WorkerModel.class).add(Restrictions.eq("workerEmail", username)));
		WorkerModel workerModel = new WorkerModel();
		if (!workerDetailsLst.isEmpty()) {
			workerModel = workerDetailsLst.get(0);

		}

		return workerModel;
	}

	@Override
	public ArrayList<WorkerModel> getWorkerListByCategory(String workerCat) {
		// TODO Auto-generated method stub
		ArrayList<WorkerModel> workerDetailsLst = new ArrayList<WorkerModel>();
		workerDetailsLst = (ArrayList<WorkerModel>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(WorkerModel.class).add(Restrictions.eq("availabilityFlag", true))
						.add(Restrictions.eq("expertiseArea", workerCat)));
		return workerDetailsLst;
	}

	@Override
	public String upDateWorker(WorkerModel catdata) {
		getHibernateTemplate().update(catdata);
		return null;
	}

}
