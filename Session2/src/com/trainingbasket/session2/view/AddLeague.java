package com.trainingbasket.session2.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddLeague extends HttpServlet {
	/** There are the default seasons for the US. */
	// private static final String DEFAULT_SEASONS = "Spring,Summer,Fall,Winter";

	/** This variable holds the set of seasons. */
	private String[] SEASONS;

	@Override
	public void init() throws ServletException {

		// getting Init values from servlet config i.e. defined within the
		// related servlet tag

		ServletConfig config = getServletConfig();
		SEASONS = config.getInitParameter("seasons").split(",");
	}

	public void generateView(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Set page title
		String pageTitle = "Duke's Soccer League: Add a New League";

		// Retrieve the errorMsgs from the request-scope
		List errorMsgs = (List) request.getAttribute("errorMsgs");

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

		// Report any errors (if any)
		if (errorMsgs != null) {
			out.println("<p>");
			out.println("<font color='red'>Please correct the following errors:");
			out.println("<ul>");
			Iterator items = errorMsgs.iterator();
			while (items.hasNext()) {
				String message = (String) items.next();
				out.println("  <li>" + message + "</li>");
			}
			out.println("</ul>");
			out.println("</font>");
			out.println("</p>");
		}

		// Generate main body
		out.println("<p>");
		out.println("This form allows you to create a new soccer league.");
		out.println("</p>");
		out.println("<form action='AddLeageController.do' method='get'>");

		// Repopulate the year field

		String year = request.getParameter("year");
		if (year == null) {
			year = "";
		}
		out.println("Year: <input type='text' name='year' value='" + year + "' /> <br/><br/>");

		// Repopulate the season drop-down menu
		String season = request.getParameter("season");
		out.println("Season: <select name='season'>");
		if ((season == null) || season.equals("UNKNOWN")) {
			out.println("          <option value='UNKNOWN'>select...</option>");
		}
		for (int i = 0; i < SEASONS.length; i++) {
			out.print("          <option value='" + SEASONS[i] + "'");
			if (SEASONS[i].equals(season)) {
				out.print(" selected");
			}
			out.println(">" + SEASONS[i] + "</option>");
		}
		out.println("        </select> <br/><br/>");

		// Repopulate the title field
		String title = request.getParameter("title");
		if (title == null) {
			title = "";
		}
		out.println("Title: <input type='text' name='title' value='" + title + "' /> <br/><br/>");

		out.println("<input type='Submit' value='Add League' />");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		generateView(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
