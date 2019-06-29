package com.trainingbasket.session2.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingbasket.session2.model.League;

public class ListLeague extends HttpServlet {

	List<League> leagues = new ArrayList<League>();

	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	
	public ListLeague() {
		leagues.add(new League(2019, "Spring", "Champions League"));
		leagues.add(new League(2019, "Winter", "Super League"));
		leagues.add(new League(2019, "Autumn", "Junior League"));
		leagues.add(new League(2019, "Summer", "Summer League"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		// Set page title
		String pageTitle = "Duke's Soccer League: List Leagues";

		// Specify the content type is HTML
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Generate the HTML response
		out.println("<html>");
		out.println("<head>");
		out.println("  <title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");

		// Generate page heading
		out.println("<!-- Page Heading -->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
		out.println("  <td><h3>" + pageTitle + "</h3></td>");
		out.println("</tr>");
		out.println("</table>");

		// Generate main body
		out.println("<p>");
		out.println("The set of soccer leagues are:");
		out.println("</p>");

		out.println("<ul>");

		// Here we are getting leagues from the list created above

		for (League league : leagues) {
			out.println("  <li>" + league + "</li>");
		}

		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
