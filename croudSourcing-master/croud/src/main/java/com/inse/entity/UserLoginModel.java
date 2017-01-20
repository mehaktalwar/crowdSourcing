package com.inse.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "userlogin", catalog = "Mysql")
public class UserLoginModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "userpk")
	private int userpk;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "identifier")
	private String identifier;

	@Transient
	private int loginID;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getUserpk() {
		return userpk;
	}

	public void setUserpk(int userpk) {
		this.userpk = userpk;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	
	

}
