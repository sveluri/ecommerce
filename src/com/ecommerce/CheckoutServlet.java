package com.ecommerce;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dao.entity.Order;
import com.ecommerce.dao.entity.OrderItem;
import com.google.gson.Gson;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
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

		String dataType = request.getParameter("data");
		OrderDAO orderDAO = new OrderDAO();
		RequestDispatcher dd = request.getRequestDispatcher("/po.jsp");
		if (dataType != null && dataType.equalsIgnoreCase("single")) {
			String orderId = request.getParameter("orderId");
			List<OrderItem> orderItems = orderDAO.getOrders(username,
					Integer.parseInt(orderId));
			List<Order> orders = orderDAO.getOrders(username);
			request.setAttribute("orders", orders);
			request.setAttribute("orderItems", orderItems);
			
		} else {

			List<Order> orders = orderDAO.getOrders(username);
			request.setAttribute("orders", orders);
			dd = request.getRequestDispatcher("/order.jsp");
		}
		dd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = "";
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("LOGIN_USER")) {
				username = cookie.getValue();
			}
		}

		RequestDispatcher dd = request.getRequestDispatcher("/order.jsp");
		if (username != null && username.length() > 0) {
			String data = request.getParameter("data");
			System.out.println(data);

			Gson gson = new Gson();

			List<OrderItem> orders = Arrays.asList(gson.fromJson(data,
					OrderItem[].class));

			OrderDAO orderDAO = new OrderDAO();
			
			orderDAO.createOrder(orders, username);

		}
		dd.forward(request, response);

	}

}
