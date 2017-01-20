package com.inse.service;

import com.inse.entity.ClientModel;

public interface ClientService {

	ClientModel getClientById(int catID);

	String createNewClient(ClientModel catdata);

	String upDateClient(String catdata);

	String deleteClient(int catID);

	ClientModel getClientByUserName(String string);

}
