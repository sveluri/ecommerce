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
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
			List<Cart> carts = cartDAO.getCart(username);

			request.setAttribute("carts", carts);

		}
		RequestDispatcher dd = request.getRequestDispatcher("/cart.jsp");
		dd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String productName = request.getParameter("productName");
		String change = request.getParameter("change");
		String username = "";
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("LOGIN_USER")) {
				username = cookie.getValue();
			}
		}

		RequestDispatcher dd = request.getRequestDispatcher("/cart.jsp");
		if (username != null && username.length() > 0) {
			Cart cart = new Cart(username, productName);

			if (change != null && change.equals("add")) {
				CartDAO cartDAO = new CartDAO();
				List<Cart> carts = cartDAO.createCart(cart);

				request.setAttribute("responseText",
						"Added to cart Succuessfully !!");
				request.setAttribute("carts", carts);
			}
			if (change != null && change.equals("remove")) {
				CartDAO cartDAO = new CartDAO();
				List<Cart> carts = cartDAO.removeFromCart(cart);

				request.setAttribute("responseText",
						"Removed from cart Succuessfully !!");
				request.setAttribute("carts", carts);
			}

		}
		request.setAttribute("responseText", "Added to cart Succuessfully !!");
		dd.forward(request, response);
	}

}
