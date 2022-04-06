package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.SecurityUtils;
import app.dao.Dao;

/**
 * Servlet implementation class Check
 */
@WebServlet("/check")

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.html");
	}
    @Override
   	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		response.setContentType("text/html");	
   		response.setCharacterEncoding("UTF-8");
   		
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