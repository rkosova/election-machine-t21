package team21.emachine;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.html");
	    rd.include(request, response);
	    
	  }
}



