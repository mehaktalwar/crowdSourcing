package com.inse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.inse.dao.UserLoginDao;
import com.inse.entity.UserLoginModel;
import com.inse.util.CustomHibernateDaoSupport;

@Repository("userLoginDao")
public class UserLoginDaoImpl extends CustomHibernateDaoSupport implements UserLoginDao  {


	
	@Override
	public String saveCredentials(UserLoginModel userLogin) {
		// TODO Auto-generated method stub
		
		//hibernateTemplate.save(userLogin);
		getHibernateTemplate().save(userLogin);
		//super.saveOrUpdate(userLogin);
		return "save";
	}

	@Override
	public UserLoginModel verifyUserCredentials(String username) {
		
		List<UserLoginModel> userLst= new ArrayList<UserLoginModel>();
		userLst=(List<UserLoginModel>)getHibernateTemplate().findByCriteria(
		        DetachedCriteria.forClass(UserLoginModel.class)
		        .add(Restrictions.eq("username", username)));
		
		if (userLst!=null && !userLst.isEmpty()) {
			return userLst.get(0);
		}
		else{
			return null;
		}
		
	}



}
