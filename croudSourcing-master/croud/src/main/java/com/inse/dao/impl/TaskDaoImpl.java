package com.inse.dao.impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.inse.dao.TaskDao;
import com.inse.entity.CategoryModel;
import com.inse.entity.ClientModel;
import com.inse.entity.TaskModel;
import com.inse.util.CustomHibernateDaoSupport;

@Repository("taskDao")
public class TaskDaoImpl extends CustomHibernateDaoSupport implements TaskDao {

	@Override
	public ArrayList<TaskModel> getInitiatedTaskByClientID(int catID) {
		// TODO Auto-generated method stub
		ArrayList<TaskModel> taskModels = new ArrayList<TaskModel>();

		taskModels = (ArrayList<TaskModel>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(TaskModel.class).add(Restrictions.eq("client.clientpk", catID))
						.add(Restrictions.eq("taskStatus", "INITIATED")));
		return taskModels;

	}

	@Override
	public String upDateTask(TaskModel taskModel) {
		
		
		getHibernateTemplate().update(taskModel);
		return "success";
	}

	@Override
	public String deleteTask(int catID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createNewTask(TaskModel catdata) {
		// TODO Auto-generated method stub

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		int saveReturn=(int) getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return saveReturn;
	}

	@Override
	public ArrayList<TaskModel> getAllTasksByClientID(int catID) {
		ArrayList<TaskModel> taskModels = new ArrayList<TaskModel>();
		taskModels = (ArrayList<TaskModel>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(TaskModel.class).add(Restrictions.eq("client.clientpk", catID)));
		return taskModels;
	}

	@Override
	public TaskModel getTaskByTaskId(int taskId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(TaskModel.class, taskId);
		// super.saveOrUpdate(userLogin);

	}

}
