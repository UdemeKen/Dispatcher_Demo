package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = null;
		if(username.equalsIgnoreCase("Udeme") && password.equals("1234")) {
			rd = request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}else {
			rd = request.getRequestDispatcher("Login.html");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center><span style='color:red'>Invalid Credentials!!!</span></center>");
		}
	}

}
