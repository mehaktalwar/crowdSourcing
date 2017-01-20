package com.inse.dao;

import java.util.ArrayList;

import com.inse.entity.CategoryModel;

public interface CategoryDao {

	CategoryModel getCategoryById(int catID);

	String createNewCategory(CategoryModel catdata);

	String upDateCategory(String catdata);

	String deleteCategory(int catID);

	ArrayList<CategoryModel> getCategoryLst();

}
