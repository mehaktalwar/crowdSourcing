package com.inse.rest;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inse.entity.CategoryModel;
import com.inse.service.CategoryService;

@Path("/category")
@Component("categoryCtrl")
public class CategoryCtrl {

	@Autowired
	CategoryService categoryService;

	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GET
	@Path("/categoryLst")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCat() {

		ArrayList<CategoryModel> status = categoryService.getCategoryLst();
		return Response.status(201).entity(status).build();

	}
	
	@GET
	@Path("/id/{catID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCatByID(@PathParam("catID") int catID) {

		CategoryModel status = categoryService.getCategoryById(catID);
		return Response.status(201).entity(status).build();

	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON )
	public Response createNewCategory(CategoryModel catdata) {
		catdata.setCreatedDate(new Date() );
		String status = categoryService.createNewCategory(catdata);

		return Response.status(201).entity(status).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(String catdata) {

		String status = categoryService.upDateCategory(catdata);

		return Response.status(201).entity(status).build();
	}

	@DELETE
	@Path("/delete/id/{catID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCategoryById(@PathParam("catID") int catID) {

		String status = categoryService.deleteCategory(catID);

		return Response.status(201).entity(status).build();
	}

}
