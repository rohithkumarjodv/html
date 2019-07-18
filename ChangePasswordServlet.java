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



@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CartAUserBo cartAUserBo;
   
    public ChangePasswordServlet() {
      cartAUserBo=new CartAUserBoImp1();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String newpass=request.getParameter("npass");
		String cnpass=request.getParameter("cnpass");
		int i=0;
		if(newpass.equals(cnpass)) {
		try {
				i=cartAUserBo.changePassword(email, newpass);
				if(i>0) {
					out.println("password updated");
					RequestDispatcher rd=request.getRequestDispatcher("Login.html");
					rd.include(request, response);
				}
				else {
					out.println("Passwords has to match");
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.html");
					rd.include(request, response);
				}
						
		}catch(Exception e) { 
			e.printStackTrace();
			}
		
		}
		else {
			out.println("Passwords has to match");
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.html");
			rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
