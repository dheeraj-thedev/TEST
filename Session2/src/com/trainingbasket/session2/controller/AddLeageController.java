package com.trainingbasket.session2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

/**
 * Servlet implementation class AddLeageController
 */
@WebServlet("/AddLeageController.do")
public class AddLeageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLeageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	List errorMsgs = new ArrayList();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errorMsgs", errorMsgs);
		
		String year = request.getParameter("year");
		String season = request.getParameter("season");
		String title = request.getParameter("title");
		
		if ( Integer.parseInt(year)!=2019) {
			errorMsgs.add("There cold only be 2019 as year");
			RequestDispatcher depatcher= getServletContext().getRequestDispatcher("/addleaguesform.view");
			depatcher.forward(request, response);
		}
		
		else {
			errorMsgs.add("There cold only be 2019 as year");
			RequestDispatcher depatcher= getServletContext().getRequestDispatcher("//.view");
			depatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
