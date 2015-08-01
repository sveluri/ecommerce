package com.ecommerce;

import java.io.IOException;
import java.sql.Timestamp;

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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String dob = request.getParameter("dob");
		String email = request.getParameter("email");

		User user = new User();
		//user.setBirthdate(new Timestamp(dob));
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		UserDAO dao = new UserDAO();
		User createdUser = dao.createUser(user);

		RequestDispatcher dd  = request.getRequestDispatcher("/user-registration.jsp");
		if(createdUser == null) {
			request.setAttribute("message",  "Creation of account with username : " + username + " failed");
		

		} else {
			request.setAttribute("message",  "Creation of account with username : " + username + " success");
		}
		dd.forward(request, response);
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
