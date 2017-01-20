package com.inse.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "workerProfile", catalog = "Mysql")
public class WorkerTaskDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "workerDetailspk")
	private int workerDetailspk;

	@Column(name = "moneyEarned")
	private int moneyEarned;

	@Column(name = "credibility")
	private int credibility; // (metric between 0 and 1) at beginning, a new
								// worker has a medium credibility (0.5). For a
								// worker with history, the credibility is
								// computed as the average of obtained rates
								// excluding the initial score of 0.5 given by
								// the system.

	@Transient
	private int experience; // number of performed tasks

	@Column(name = "appreciation")
	private String appreciation; // given by client

	@Column(name = "taskStatus")
	private String taskStatus;

/*	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pkWorker")
	private WorkerModel workerModel;*/
	
/*	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "taskpk")
	private TaskModel task;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pkWorker")
	private WorkerModel workerModel;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientpk")
	private ClientModel clientModel;*/
	
	@JoinColumn(name = "workerId")
	private int workerId;

	@JoinColumn(name = "clientId")
	private int clientId;
	
	@JoinColumn(name = "taskID")
	private int taskID;
	

	@Transient
	private String clientName;

	@Transient
	private String taskDesc;
	
	@Transient
	private String taskTitle;  
	
	@Column(name = "createdDate")
	private Date createdDate;

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public int getWorkerDetailspk() {
		return workerDetailspk;
	}

	public void setWorkerDetailspk(int workerDetailspk) {
		this.workerDetailspk = workerDetailspk;
	}

	public int getMoneyEarned() {
		return moneyEarned;
	}

	public void setMoneyEarned(int moneyEarned) {
		this.moneyEarned = moneyEarned;
	}

	public int getCredibility() {
		return credibility;
	}

	public void setCredibility(int credibility) {
		this.credibility = credibility;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}



	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

/*	public WorkerModel getWorkerModel() {
		return workerModel;
	}

	public void setWorkerModel(WorkerModel workerModel) {
		this.workerModel = workerModel;
	}
*/

	
	

}
