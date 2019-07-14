package com.trainingbasket.session2.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class League {

	int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	int year;
	String season;
	String title;

	public League() {
		// TODO Auto-generated constructor stub
	}
	public League(int year, String season, String title) {
		this.title = title;
		this.season = season;
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.title + "\t" + this.season + "\t" + this.year;
	}
/*
	public static void main(String[] args) {

		List<League> leagues = new ArrayList<League>();

		leagues.add(new League(2019, "Spring", "Champions League"));
		leagues.add(new League(2019, "Winter", "Super League"));
		leagues.add(new League(2019, "Autumn", "Junior League"));
		leagues.add(new League(2019, "Summer", "Summer League"));

		
		System.out.println("The Iterator Way");
		Iterator<League> leagueIterator = leagues.iterator();
		while (leagueIterator.hasNext()) {
			System.out.println(leagueIterator.next());
		}

		System.out.println("The Enhanced For Loop Way");
		
		for (League league : leagues) {
			System.out.println("  <li>" + league + "</li>");

		}
	}
*/
}
