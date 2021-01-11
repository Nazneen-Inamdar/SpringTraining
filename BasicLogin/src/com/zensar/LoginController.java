package com.zensar;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet  {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		String requestAction=request.getParameter("requestAction");
		
		if(requestAction.equals("login"))
		{
			boolean output;
			 String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				LoginRepository login=new LoginRepository();
				output=login.viewUser(username, password);
				System.out.println(output);
				if(output)
				{
					RequestDispatcher rd=request.getRequestDispatcher("LoginSucess.jsp");
					try {
						rd.forward(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("Login Failed");
					
					request.setAttribute("message","Invalid Credentials..");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					try {
						rd.forward(request,response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		doGet(request,response);
	}
}