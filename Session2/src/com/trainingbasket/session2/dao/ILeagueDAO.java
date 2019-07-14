package com.trainingbasket.session2.dao;

import java.sql.SQLException;
import java.util.List;

import com.trainingbasket.session2.model.League;

public interface ILeagueDAO {
	 List<League> getAllLeagues()throws SQLException;
	 boolean insertLeague(League league);
	 League getLeagueById(int leagueId);
}
