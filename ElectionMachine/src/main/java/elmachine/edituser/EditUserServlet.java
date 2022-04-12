package elmachine.edituser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import elmachine.register.bean.RegisterBean;
import elmachine.edituser.EditUserDao;
import elmachine.register.util.DBConnection;


@WebServlet("/EditUser")
public class EditUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					String uID=request.getParameter("userID");
					int userid=Integer.parseInt(uID);
					String firstName = request.getParameter("firstName");
			        String lastName = request.getParameter("lastName");
			        String role = request.getParameter("role");
			        String email = request.getParameter("email");
			        String userName = request.getParameter("userName");
			        String password = request.getParameter("password");
			         
			        RegisterBean bean = new RegisterBean();
			        bean.setUserID(userid);  
			        bean.setFirstName(firstName);  
			        bean.setLastName(lastName);  
			        bean.setRole(role);  
			        bean.setEmail(email);  
			        bean.setPassword(password);  
			        bean.setUserName(userName);  
					EditUserDao.update(bean);
					response.sendRedirect("/ShowUser");
			}


}

