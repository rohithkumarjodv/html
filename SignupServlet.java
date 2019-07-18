package com.mphasis.training.example;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImp1;
import com.mphasis.cart.exceptions.BuissnessException;


@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartAUserBo cartAUserBo;
       
    
    public SignupServlet() {
    	cartAUserBo=new CartAUserBoImp1();
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("welcome");
		int userid=Integer.parseInt(request.getParameter("userid"));
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int credit=Integer.parseInt(request.getParameter("credit"));
		String gender=request.getParameter("gender");
		CartAUser user=new CartAUser();
		user.setUserid(userid);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
	    user.setCredit(credit);
		user.setGender(gender);
		try {
			System.out.println("servlet Called");
			cartAUserBo.register(user);
			RequestDispatcher rd=request.getRequestDispatcher("menu.html");
			rd.include(request, response);
			out.print("updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Invalid credentials");
		response.sendRedirect("Signup.html");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
