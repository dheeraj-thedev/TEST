package com.trainingbasket.session2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainingbasket.session2.model.League;
import com.trainingbasket.utils.ConnectionUtils;

public class LeagueDAOImpl implements ILeagueDAO {

	Connection conn;
	Statement statement;
	ResultSet resultSet;

	public LeagueDAOImpl() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = ConnectionUtils.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	@Override
	public List<League> getAllLeagues() throws SQLException {
		List<League> leaguesList = new ArrayList<League>();
		//conn = ConnectionUtils.getConnection();
		statement = conn.createStatement();
		resultSet = statement.executeQuery("Select * from Leagues");
		while (resultSet.next()) {
			League league = new League();
			league.setId(resultSet.getInt("leagueId"));
			league.setYear(resultSet.getInt("year"));
			league.setTitle(resultSet.getString("title"));
			league.setSeason(resultSet.getString("season"));
			leaguesList.add(league);
		}
		return leaguesList;
	}

	@Override
	public boolean insertLeague(League league) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public League getLeagueById(int leagueId) {
		// TODO Auto-generated method stub
		return null;
	}

}
