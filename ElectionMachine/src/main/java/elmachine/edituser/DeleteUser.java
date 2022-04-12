package elmachine.edituser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elmachine.register.bean.RegisterBean;
import elmachine.register.util.DBConnection;
import elmachine.edituser.EditUserDao;
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uID=request.getParameter("userID");
		int userID=Integer.parseInt(uID);
		EditUserDao.delete(userID);
		response.sendRedirect("/ShowUser");
	}
}