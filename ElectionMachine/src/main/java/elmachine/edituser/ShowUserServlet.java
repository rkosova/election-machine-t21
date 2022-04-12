package elmachine.edituser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elmachine.register.bean.RegisterBean;
import elmachine.register.util.DBConnection;
import elmachine.edituser.EditUserDao;

@WebServlet("/ShowUser")
public class ShowUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Users</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		List<RegisterBean> list=EditUserDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>User Id</th><th>First Name</th><th>Last Name</th><th>Role</th><th>Email</th><th>Password</th><th>Username</th><th>Edit</th><th>Delete</th></tr>");
		for(RegisterBean bean:list){
			out.println("<tr><td>"+bean.getUserID()+"</td><td>"+bean.getFirstName()+"</td><td>"+bean.getLastName()+"</td><td>"+bean.getRole()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getUserName()+"</td><td><a href='EditUserForm?userID="+bean.getUserID()+"'>Edit</a></td><td><a href='DeleteUser?userID="+bean.getUserID()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}
}
