package com.inse.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inse.dao.CategoryDao;
import com.inse.entity.CategoryModel;
import com.inse.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl  implements CategoryService{

	
	@Autowired
	CategoryDao categoryDao;
	

	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public CategoryModel getCategoryById(int catID) {
		// TODO Auto-generated method stub
		
		CategoryModel status=categoryDao.getCategoryById(catID);
		return status;
	}



	@Override
	public String upDateCategory(String catdata) {
		// TODO Auto-generated method stub
		String status=categoryDao. upDateCategory( catdata);
		return status;
	}

	@Override
	public String deleteCategory(int catID) {
		// TODO Auto-generated method stub
		String status=categoryDao.deleteCategory( catID);
		return status;
	}

	@Override
	public String createNewCategory(CategoryModel catdata) {
		String status=categoryDao.createNewCategory( catdata);
		return status;
	}

	@Override
	public ArrayList<CategoryModel> getCategoryLst() {
		// TODO Auto-generated method stub
		 ArrayList<CategoryModel> catLst=categoryDao.getCategoryLst( );
		return catLst;
	}


}
