package com.inse.entity;

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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "worker", catalog = "Mysql")
public class WorkerModel {

	@Id
	@GeneratedValue
	@Column(name = "pkWorker")
	private int pkWorker;

	@Column(name = "workerName")
	private String workerName;

	@Column(name = "workeraddress")
	private String workeraddress;

	@Column(name = "workerEmail")
	private String workerEmail;

	@Column(name = "workerPassword")
	private String workerPassword;

	@Column(name = "expertiseArea")
	private String expertiseArea; // tasks he can perform

	@Column(name = "levelExpertise")
	private String levelExpertise;

	@Column(name = "servicefee")
	private int servicefee;

	@Column(name = "availability")
	private boolean availabilityFlag;
	
	@Column(name = "totalMoneyEarned")
	private double totalMoneyEarned;
	
	@Column(name = "crediblity")
	private double crediblity=5.0;
	
	@Column(name = "experince")
	private int experince;

	@Column(name = "createdDate")
	private Date createdDate;
	
	/*@OneToMany(mappedBy = "workerModel" ,fetch = FetchType.EAGER)
	private Collection<WorkerTaskDetails> workerTaskDetails = new ArrayList<WorkerTaskDetails>();*/

	public int getServicefee() {
		return servicefee;
	}


	public void setServicefee(int servicefee) {
		this.servicefee = servicefee;
	}

	public boolean isAvailabilityFlag() {
		return availabilityFlag;
	}

	public void setAvailabilityFlag(boolean availabilityFlag) {
		this.availabilityFlag = availabilityFlag;
	}

	



/*	public Collection<WorkerTaskDetails> getWorkerTaskDetails() {
		return workerTaskDetails;
	}

	public void setWorkerTaskDetails(Collection<WorkerTaskDetails> workerTaskDetails) {
		this.workerTaskDetails = workerTaskDetails;
	}*/



	public int getPkWorker() {
		return pkWorker;
	}


	public void setPkWorker(int pkWorker) {
		this.pkWorker = pkWorker;
	}


	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkeraddress() {
		return workeraddress;
	}

	public void setWorkeraddress(String workeraddress) {
		this.workeraddress = workeraddress;
	}

	public String getWorkerEmail() {
		return workerEmail;
	}

	public void setWorkerEmail(String workerEmail) {
		this.workerEmail = workerEmail;
	}

	public String getWorkerPassword() {
		return workerPassword;
	}

	public void setWorkerPassword(String workerPassword) {
		this.workerPassword = workerPassword;
	}

	public String getExpertiseArea() {
		return expertiseArea;
	}

	public void setExpertiseArea(String expertiseArea) {
		this.expertiseArea = expertiseArea;
	}

	public String getLevelExpertise() {
		return levelExpertise;
	}

	public void setLevelExpertise(String levelExpertise) {
		this.levelExpertise = levelExpertise;
	}

	public double getTotalMoneyEarned() {
		return totalMoneyEarned;
	}


	public void setTotalMoneyEarned(double totalMoneyEarned) {
		this.totalMoneyEarned = totalMoneyEarned;
	}


	public double getCrediblity() {
		return crediblity;
	}


	public void setCrediblity(double crediblity) {
		this.crediblity = crediblity;
	}


	public int getExperince() {
		return experince;
	}


	public void setExperince(int experince) {
		this.experince = experince;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
