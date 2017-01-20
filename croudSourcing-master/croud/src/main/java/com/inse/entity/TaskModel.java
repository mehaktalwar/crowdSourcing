package com.inse.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "task", catalog = "Mysql")
public class TaskModel implements Serializable {

	
	@Id
	@GeneratedValue
	@Column(name = "taskpk")
	private int taskpk;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "categoryCode")
	private String categoryCode;	//there should be 1-1 mapping b/w category and Worker expertiseArea
	
	@Column(name = "location")
	private String location; 	//optional..user should enter or choose from dropdown
	
	@Column(name = "timeLimit")
	private int timeLimitHours;		//hours or days
	
	@Column(name = "budget")
	private int budget;			//CAD

	@Column(name = "maxWorker")
	private int maxWorker;
	//Maximum number of workers 
	
	@Column(name = "contactDetails")
	private String contactDetails;  //Contact details
	
	@Transient
	private String imageURL;		//store image link
	
	@Column(name="workerStatus")
	private String workerStatus;
	
	
	@Column(name="workerId")
	private int workerId;
	
	@Column(name="taskStatus")
	private String taskStatus;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="clientpk")
	private ClientModel client;
	
	/*@OneToOne(mappedBy = "task")
	private WorkerTaskDetails workerTaskDetails;*/
	
	@Transient
	private String clientUsername;

	@Column(name = "taskPayment")
	private int taskPayment;
	
	@Column(name = "taskFeedback")
	private int taskFeedback;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getTitle() {
		return title;
	}

	public int getTaskpk() {
		return taskpk;
	}

	public void setTaskpk(int taskpk) {
		this.taskpk = taskpk;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTimeLimitHours() {
		return timeLimitHours;
	}

	public void setTimeLimitHours(int timeLimitHours) {
		this.timeLimitHours = timeLimitHours;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getMaxWorker() {
		return maxWorker;
	}

	public void setMaxWorker(int maxWorker) {
		this.maxWorker = maxWorker;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}



	public String getClientUsername() {
		return clientUsername;
	}

	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	public int getTaskPayment() {
		return taskPayment;
	}

	public void setTaskPayment(int taskPayment) {
		this.taskPayment = taskPayment;
	}

	public int getTaskFeedback() {
		return taskFeedback;
	}

	public void setTaskFeedback(int taskFeedback) {
		this.taskFeedback = taskFeedback;
	}

	public String getWorkerStatus() {
		return workerStatus;
	}

	public void setWorkerStatus(String workerStatus) {
		this.workerStatus = workerStatus;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

/*	public WorkerTaskDetails getWorkerTaskDetails() {
		return workerTaskDetails;
	}

	public void setWorkerTaskDetails(WorkerTaskDetails workerTaskDetails) {
		this.workerTaskDetails = workerTaskDetails;
	}

	*/
	
	
	
	
}
