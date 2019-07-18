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

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImp1;



@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      CartAUserBo cartAUserBo;
   
    public LoginServlet() {
        cartAUserBo=new CartAUserBoImp1();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("pwd");
		//String email=request.getParameter("email");
		//String cno=request.getParameter("credit");
		
		try {
			CartAUser user=cartAUserBo.login(name,pass);
		if(user.getEmail().equals(name)&&user.getPassword().equals(pass)) {
		     out.print("Welcome  "+name+"</br>");
		     
		     out.print("</br>");
		     RequestDispatcher rd=request.getRequestDispatcher("menu.html");
				rd.include(request, response);
				//out.print("ur rewriting");
				//out.print("<a href='ProfileServlet?uname="+name>);
				//Cookie
				//Cookie ck=new Cookie("cname",name);
				//response.addCookie(ck);
				//HttpSession
				HttpSession session=request.getSession();
				session.setAttribute("sname",name);
				
				
		}
		}
		catch(Exception e) {
			out.print("invalid");
			response.sendRedirect("login.html");
			e.printStackTrace();
		}
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
