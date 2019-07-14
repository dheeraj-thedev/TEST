package com.trainingbasket.session2.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.trainingbasket.session2.model.League;


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

		if (Integer.parseInt(year) != 2019) {
			errorMsgs.add("There cold only be 2019 as year");
			RequestDispatcher depatcher = getServletContext().getRequestDispatcher("/addleaguesform.view");
			depatcher.forward(request, response);
		} else {
			League league = new League(Integer.parseInt(year), season, title);
			List<League> leagueList = (List<League>) getServletContext().getAttribute("leagueList");
			
			//insert 
			//read
			
			leagueList.add(league);
			String filePath = "/LeagueData.csv";
			// path getServletContext().getResource(filePath).getRef();
			Files.delete(Paths.get(getServletContext().getRealPath(filePath)));
			Files.write(Paths.get(getServletContext().getRealPath(filePath)), getBytes(leagueList));

			RequestDispatcher depatcher = getServletContext().getRequestDispatcher("/listleagues.view");
			depatcher.forward(request, response);
		}
	}

	private byte[] getBytes(List<League> leagueList) {
		String csvData = "";
		for (League league : leagueList) {
			csvData += league.getYear() + "," + league.getSeason() + "," + league.getTitle() + "\n";
		}
		return csvData.getBytes();
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
