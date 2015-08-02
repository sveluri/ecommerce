package com.ecommerce;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.entity.Cart;

/**
 * Servlet implementation class CartCountServlet
 */
@WebServlet("/cartcount")
public class CartCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartCountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = "";
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("LOGIN_USER")) {
				username = cookie.getValue();
			}
		}
		if (username != null && username.length() > 0) {

			CartDAO cartDAO = new CartDAO();
			int cartCount = cartDAO.getCartCount(username);

			response.setContentType("text/plain");
			response.getWriter().write(cartCount);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
