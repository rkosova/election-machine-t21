package team21.emachine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team21.emachine.Dao.Dao;

/**
 * Servlet implementation class AddUser
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/add"}
)
public class AddUser extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
	
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	
		response.sendRedirect("index.html");
		}
	@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
	
Dao dao = new Dao();
   		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
	
		// Create salt and hashed PW
		String salt = SecurityUtils.getSalt();
		String hashed = SecurityUtils.getPasswordHashed(password, salt);
	
		dao.addUser(uname, hashed, salt);
	
		dao.close();
		response.sendRedirect("index.html");
		}
}