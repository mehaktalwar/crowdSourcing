package com.inse.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "category", catalog = "Mysql")
public class CategoryModel implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "categorypk")
	private int categorypk;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	@Column(name = "categoryDesc")
	private String categoryDesc;

	@Column(name = "createdDate")
	private Date createdDate;

	public int getCategorypk() {
		return categorypk;
	}

	public void setCategorypk(int categorypk) {
		this.categorypk = categorypk;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	
	

}
