package com.trainingbasket.utils;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.Session;

import com.trainingbasket.session2.model.League;

public class ContextListner implements ServletContextListener {

	public static void main(String[] args) {
		try {
			InputStream input = ContextListner.class.getClassLoader().getResourceAsStream("test.properties");
			Properties prop = new Properties();
			if (input == null) {
				System.out.println("Sorry, unable to find test.properties");
				return;
			}
			prop.load(input);

			System.out.println(prop.getProperty("DBServername"));
			System.out.println(prop.getProperty("user"));
			System.out.println(prop.getProperty("pass"));
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("port"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			InputStream input = ContextListner.class.getClassLoader().getResourceAsStream("test.properties");
			Properties prop = new Properties();
			if (input == null) {
				System.out.println("Sorry, unable to find test.properties");
				return;
			}
			prop.load(input);
			sce.getServletContext().setAttribute("dbProiperties", prop);
		} catch (Exception e) {
			// TODO: handle exception
		}

		/*
		 * try { // Read a property file
		 * 
		 * List<League> leagueList = new ArrayList<League>();
		 * sce.getServletContext().setAttribute("leagueList", leagueList); String
		 * filePath = "/LeagueData.csv"; System.out.println(filePath); InputStream is =
		 * sce.getServletContext().getResourceAsStream(filePath); InputStreamReader sr =
		 * new InputStreamReader(is); BufferedReader bufferedReader = new
		 * BufferedReader(sr); String line = ""; while ((line =
		 * bufferedReader.readLine()) != null) { System.err.println("Line : " + line);
		 * String columns[] = line.split(","); League league = new
		 * League(Integer.parseInt(columns[2]), columns[1], columns[0]);
		 * System.out.println(league.toString()); leagueList.add(league); } } catch
		 * (Exception e) { System.out.println(e.getMessage()); e.printStackTrace();
		 * 
		 * }
		 */
	}

}
