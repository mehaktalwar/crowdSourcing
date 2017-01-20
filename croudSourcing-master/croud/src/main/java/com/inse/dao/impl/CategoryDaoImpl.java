package com.inse.dao.impl;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import com.inse.dao.CategoryDao;
import com.inse.entity.CategoryModel;
import com.inse.entity.UserLoginModel;
import com.inse.util.CustomHibernateDaoSupport;

@Repository("categoryDao")
public class CategoryDaoImpl extends CustomHibernateDaoSupport implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public CategoryModel getCategoryById(int catID) {

		CategoryModel categoryLst = new CategoryModel();

		getHibernateTemplate().get(CategoryModel.class, catID);
		// categoryLst= (ArrayList<CategoryModel>)
		// getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(CategoryModel.class));
		// getHibernateTemplate().findByExample(CategoryModel.class);

		return categoryLst;
	}

	@Override
	public String upDateCategory(String catdata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCategory(int catID) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(CategoryModel.class, catID));
		return "success";
	}

	@Override
	public String createNewCategory(CategoryModel catdata) {
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
	public ArrayList<CategoryModel> getCategoryLst() {
		ArrayList<CategoryModel> categoryLst = (ArrayList<CategoryModel>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(CategoryModel.class));
		return categoryLst;
	}

}
