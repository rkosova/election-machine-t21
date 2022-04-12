package elmachine.adduser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import elmachine.register.bean.RegisterBean;
import elmachine.adduser.AddUserDao;
import elmachine.register.util.DBConnection;
 
public class AddUserServlet extends HttpServlet {
	  
    public AddUserServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //Copying all the input parameters in to local variables
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
         
        RegisterBean registerBean = new RegisterBean();
       //Using Java Beans - An easiest way to play with group of related data
        registerBean.setFirstName(firstName);
        registerBean.setLastName(lastName);
        registerBean.setRole(role);
        registerBean.setEmail(email);
        registerBean.setUserName(userName);
        registerBean.setPassword(password); 
         
        AddUserDao addUserDao = new AddUserDao();
         
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = addUserDao.registerUser(registerBean);
         
        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
           request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", userRegistered);
           request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
    }
   
}