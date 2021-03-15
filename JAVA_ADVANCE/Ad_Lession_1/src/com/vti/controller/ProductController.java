package com.vti.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vti.entity.Product;

/**
 * Servlet implementation class CreateProductController
 */
@WebServlet("/productList")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static List<Product> products;

	public ProductController() {
		products = new ArrayList<>();
		products.add(new Product("Code 1", "A", "500k"));
		products.add(new Product("Code 2", "B", "600k"));
	}

	public List<Product> getListProducts() {
		return products;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// forward to login.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/productList.jsp");
		dispatcher.forward(request, response);
	}

}
