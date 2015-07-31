package com.ecommerce;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.dao.entity.RoleType;
import com.ecommerce.dao.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAO UserDao = new UserDAO();

		User user = UserDao.getUser(username, password);

		if (user != null) {

			RequestDispatcher dd = null;
			String role = user.getRole();

			dd = request.getRequestDispatcher("/home.jsp");
			if (RoleType.ADMIN.name().equalsIgnoreCase(role)) {
				dd = request.getRequestDispatcher("/admin-home.jsp");
			}

			Cookie loginCookie = new Cookie("LOGIN_USER", username);
			loginCookie.setMaxAge(5 * 60);
			response.addCookie(loginCookie);
			Cookie first = new Cookie("FIRST_TIME",
					String.valueOf(Boolean.FALSE));
			first.setMaxAge(5 * 60);
			response.addCookie(first);

			request.setAttribute("username", username);

			dd.forward(request, response);
		} else {
			request.setAttribute("profile_msg", "Login failed !!");
			Cookie first = new Cookie("FIRST_TIME",
					String.valueOf(Boolean.FALSE));
			first.setMaxAge(5 * 60);
			response.addCookie(first);
			RequestDispatcher dd = request.getRequestDispatcher("/index.jsp");

			dd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
