package com.vti.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vti.bussinesslayer.IUserService;
import com.vti.bussinesslayer.UserService;
import com.vti.entity.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	@Override
	public void init() throws ServletException {
		try {
			userService = new UserService();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/login.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get Parameter from client:
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Comparing //username and password
		try {
			User user = userService.login(username, password);

			if (user != null) {
				// save cookies

				addCookie(response, "username", user.getUsername());
				addCookie(response, "password", user.getPassword());
				addCookie(response, "role", user.getRole());

				// login success
				// forward to home page

				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				// login fail

				String messageErorr = "Username or password is fail! Try again";
				request.setAttribute("username", username);
				request.setAttribute("messageErorr", messageErorr);

				// Cách 1: sử dụng sendRedirect: response.sendRedirect(request.getContextPath()
				// + "/login?username=");

				// Cách 2: Forward to login page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/login.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void addCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
	}
}
