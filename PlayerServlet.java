package com.mphasis.player.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.player.beans.Player;
import com.mphasis.player.bo.PlayerBo;
import com.mphasis.player.bo.PlayerBoImp;
import com.mphasis.player.dao.PlayerDao;


@WebServlet("/Playerservlet")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   PlayerBo playerbo;
   
    public PlayerServlet() {
    	playerbo=new PlayerBoImp();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			
			
			List<Player> player=playerbo.getAllPlayers();
			System.out.println(player);
			out.print("<table border='1'>");
			out.print("<tr><th>PID</th><th>Name</th><th>Gender</th>"+"<th>Contact</th><th>Email</th><th>Teamname</th><th>age</th><th>Dob</th><th>Score</th></tr>");
			for(Player p: player) {
				out.print("<tr>");
				out.print("<td>"+p.getPid()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getGender()+"</td>");
				out.print("<td>"+p.getContact()+"</td>");
				out.print("<td>"+p.getEmail()+"</td>");
				out.print("<td>"+p.getTeamname()+"</td>");
				out.print("<td>"+p. getAge()+"</td>");
				out.print("<td>"+p.getDob()+"</td>");
				out.print("<td>"+p.getScore()+"</td>");
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("Player.html");
			rd.include(request, response);
		}
				catch(NullPointerException e) {
					e.printStackTrace();
					
					
				}
					
				}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
