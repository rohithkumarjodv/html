package com.mphasis.training.example;

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

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImp1;


@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;
    
    public ProductServlet() {
    	productDao=new ProductdaoImp1();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products=productDao.getAll();
		HttpSession session=request.getSession();
		session.setAttribute("product", products);
		response.sendRedirect("product.jsp");}
		/*response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Expires", "0");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
		HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print("Product page " +s);
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		System.out.println("product page");
		List<Product> products=productDao.getAll();
		System.out.println(products);
		out.print("<table border='1'>");
		out.print("<tr><th>PID</th><th>PName</th><th>Cost</th>"+"<th>Quantity</th><th>Buy</th></tr>");
		for(Product p: products) {
			out.print("<tr>");
			out.print("<td>"+p.getPid()+"</td>");
			out.print("<td>"+p.getPname()+"</td>");
			out.print("<td>"+p.getCost()+"</td>");
			out.print("<td>"+p.getQuantity()+"</td>");
			out.print("<td><a>Buy</a></td>");
					
		}
		
		
		
	}catch(NullPointerException e) {
		e.printStackTrace();
		out.print("Login First");
		RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		rd.include(request, response);
	}
		
	}
*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
