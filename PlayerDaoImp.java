package com.mphasis.player.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.player.beans.Player;
import com.mphasis.player.dbutil.DbUtil;

public class PlayerDaoImp implements PlayerDao {

	
	Connection conn;
	 
	public PlayerDaoImp() {
		conn=DbUtil.openConnection();
		
	}
	@Override
	public List<Player> getAllPlayers() {
		List<Player> ps =new ArrayList<>();
		 try { 
			 String sql="select * from Player";
		
		  PreparedStatement pst=conn.prepareStatement(sql);
		   ResultSet rs=pst.executeQuery();
		  while(rs.next())
		  {
			  Player p1 =new Player();
			  p1.setPid(rs.getInt(1));
			  p1.setName(rs.getString(2));
			  p1.setGender(rs.getString(3));
			  p1.setContact(rs.getLong(4));
			  p1.setEmail(rs.getString(5));
			  p1.setTeamname(rs.getString(6));
			  p1.setAge(rs.getInt(7));
			  p1.setDob(rs.getDate(8));
			  p1.setScore(rs.getLong(9));
			  ps.add(p1);
			  
		  } }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
			 
		return ps;
	}
}