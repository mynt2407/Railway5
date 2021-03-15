package com.vti.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vti.entity.Product;

/**
 * Servlet implementation class CreateProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static List<Product> products;

	public ProductController() {
		products = new ArrayList<>();
		products.add(new Product("Code 1", "A", "500k"));
		products.add(new Product("Code 2", "B", "600k"));
	}

	public List<Product> getListProducts() {
		return products;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String price = request.getParameter("price");

		products.add(new Product(code, name, price));

	}

}
