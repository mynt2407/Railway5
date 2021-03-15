package com.vti.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getCookieBykey(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}

//forward to main.jsp

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get cookie
		String username = getCookieBykey(request, "username");

		System.out.println("UserName của bạn là: "+ username);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		out.print("<html><body>");
//		out.println("User " + username);
//		out.print("</body></html>");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/program.jsp");
		requestDispatcher.forward(request, response);
	}

}
