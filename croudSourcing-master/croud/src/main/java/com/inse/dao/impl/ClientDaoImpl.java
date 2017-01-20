package com.inse.dao.impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.inse.dao.ClientDao;
import com.inse.entity.ClientModel;
import com.inse.entity.WorkerModel;
import com.inse.util.CustomHibernateDaoSupport;

@Repository("clientDao")
public class ClientDaoImpl extends CustomHibernateDaoSupport implements ClientDao {

	@Override
	public ClientModel getClientById(int catID) {
		// TODO Auto-generated method stub

		ClientModel clientModel = getHibernateTemplate().get(ClientModel.class, catID);
		return clientModel;
	}

	@Override
	public String upDateClient(String catdata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClient(int catID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createNewClient(ClientModel catdata) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(catdata);
		// super.saveOrUpdate(userLogin);
		return "success";
	}

	@Override
	public ClientModel getClientByUserName(String username) {
		// TODO Auto-generated method stub
		ArrayList<ClientModel> clientsLst = new ArrayList<ClientModel>();
		ClientModel clientModel = new ClientModel();
		clientsLst = (ArrayList<ClientModel>) getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(ClientModel.class).add(Restrictions.eq("clientEmail", username)));

		if (!clientsLst.isEmpty()) {
			clientModel = clientsLst.get(0);
		}
		return clientModel;
	}

}
