package elmachine.register.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import elmachine.register.bean.RegisterBean;
import elmachine.register.util.DBConnection;
 
public class RegisterDao { 
     public String registerUser(RegisterBean registerBean)
     {
         String firstName = registerBean.getFirstName();
         String lastName = registerBean.getLastName();
         String email = registerBean.getEmail();
         String userName = registerBean.getUserName();
         String password = registerBean.getPassword();
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into users(firstName, lastName, role, Email,userName,password) values (?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, firstName);
             preparedStatement.setString(2, lastName);
             preparedStatement.setString(3, "User");
             preparedStatement.setString(4, email);
             preparedStatement.setString(5, userName);
             preparedStatement.setString(6, password);
              
             int i= preparedStatement.executeUpdate();
              
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
}