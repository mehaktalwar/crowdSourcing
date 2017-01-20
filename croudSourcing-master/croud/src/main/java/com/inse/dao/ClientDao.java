package com.inse.dao;

import com.inse.entity.ClientModel;

public interface ClientDao {

	ClientModel getClientById(int catID);

	String upDateClient(String catdata);

	String deleteClient(int catID);

	String createNewClient(ClientModel catdata);

	ClientModel getClientByUserName(String username);

}
