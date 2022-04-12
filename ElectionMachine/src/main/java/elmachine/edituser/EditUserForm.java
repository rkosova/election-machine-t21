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
@WebServlet("/EditUserForm")
public class EditUserForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit User Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		String uid=request.getParameter("userID");
		int userID=Integer.parseInt(uid);
		
		RegisterBean bean=EditUserDao.viewById(userID);
		
		out.print("<form action='/EditUser' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='userID' value='"+bean.getUserID()+"'/>");
		out.print("<label for='name1'>First Name</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getFirstName()+"' name='firstName' id='fname1' placeholder='First Name'/>");
		out.print("<label for='name1'>Last Name</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getLastName()+"' name='lastName' id='lname1' placeholder='Last Name'/>");
		out.print("<label for='name1'>Role</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getRole()+"' name='role' id='role1' placeholder='Role'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email address</label>");
		out.print("<input type='email' class='form-control' value='"+bean.getEmail()+"'  name='email' id='email1' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='password1'>Password</label>");
		out.print("<input type='password' class='form-control' value='"+bean.getPassword()+"'  name='password' id='password1' placeholder='Password'/>");
		out.print("</div>  ");
		out.print("<div class='form-group'>");
		out.print("<label for='mobile1'>Username</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getUserName()+"'  name='userName' id='password1' placeholder='UserName'/>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}
}

