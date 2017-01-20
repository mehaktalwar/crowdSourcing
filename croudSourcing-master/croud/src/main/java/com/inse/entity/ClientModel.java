package com.inse.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "client", catalog = "Mysql")
public class ClientModel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "clientpk")
	private int clientpk;
	
	@Column(name = "clientName")
	private String clientName;
	
	@Column(name = "clientEmail")
	private String clientEmail;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "paymentMethod")
	private String paymentMethod ;	//a pre-registered credit card or PayPal account, or any other payment method
	
	@Column(name = "paymentInfo")
	private String paymentInfo;					// to store card or PayPal account details

	@Column(name = "createdDate")
	private Date createdDate;
	//@OneToOne(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
	//private TaskModel task;
	
/*	public TaskModel getTask() {
		return task;
	}

	public void setTask(TaskModel task) {
		this.task = task;
	}*/



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getClientName() {
		return clientName;
	}

	public int getClientpk() {
		return clientpk;
	}

	public void setClientpk(int clientpk) {
		this.clientpk = clientpk;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

/*	public Collection<TaskModel> getTask() {
		return task;
	}

	public void setTask(Collection<TaskModel> task) {
		this.task = task;
	}
*/
	

	
	
	


}
