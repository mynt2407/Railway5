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
@WebServlet("/createProduct")
public class CreateProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// forward to login.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/CreateProduct.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String price = request.getParameter("price");

		ProductController.products.add(new Product(code, name, price));

		response.sendRedirect("http://localhost:8080/Lession2_Version2/productList");

	}

}
