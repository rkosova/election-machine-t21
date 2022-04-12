package elmachine.edituser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import elmachine.register.bean.RegisterBean;
@WebServlet(name = "updateUser", value = "/updateUser")
public class UpdateUser extends HttpServlet {
    // override the supertype method post
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        
        // collect user id parameter
        String uID=request.getParameter("userID");
		int userID=Integer.parseInt(uID);
            
            // this statement get user by id
            RegisterBean user = EditUserDao.viewById(userID);
            
            // this print the jsp and render web page
            out.println("<h2>Edit User Account</h2>");
            out.print(
                "<form action='patchUser' method='post'>");
            out.print("<table>");
            out.print(
                "<tr><td></td><td><input type='hidden' name='id' value='"
                + user.getUserID() + "'/></td></tr>");
            out.print(
                "<tr><td>Name:</td><td><input type='text' name='name' value='"
                + user.getUserName() + "'/></td></tr>");
            out.print(
                "<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
            out.print("</table>");
            out.print("</form>");
            
            // close database connection
            out.close();
        
}}