package com.mphasis.training.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfileServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
		HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print("Profile page " +s);
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		
	}catch(NullPointerException e) {
		out.print("Login First");
		RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		rd.include(request, response);
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
