package team21.emachine;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team21.emachine.Dao.Dao;



@WebServlet(
	    name = "LoginPage",
	    urlPatterns = {"/login"}
	)
public class LoginPage extends HttpServlet{
	
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {

	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	   
	    
	  }
	  
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  
		Dao conn = new Dao();
		
		String username = request.getParameter("uname");
		String password = request.getParameter("Pass");
		
		String salt = SecurityUtils.getSalt();
		String hashed = SecurityUtils.getPasswordHashed(password, salt);
		
		String db_return = conn.getUserPasswordHash(username);
		
		if (db_return != null) {
			// login code
		}
	  }
}



