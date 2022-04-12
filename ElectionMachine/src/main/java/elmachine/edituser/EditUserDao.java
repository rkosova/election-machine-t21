package elmachine.edituser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import elmachine.register.bean.RegisterBean;
import elmachine.register.util.DBConnection;
 
public class EditUserDao { 
	public static String update(RegisterBean bean){
		Connection con = null;
        PreparedStatement preparedStatement = null;         
        try
        {
            con = DBConnection.createConnection();
            String query = "update users set userID=?,firstName=?,lastName=?,role=?,Email=?,userName=?,password=? where userID=?"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setInt(1,bean.getUserID());
            preparedStatement.setString(2,bean.getFirstName());
            preparedStatement.setString(3,bean.getLastName());
            preparedStatement.setString(4,bean.getRole());
            preparedStatement.setString(5,bean.getEmail());
            preparedStatement.setString(6,bean.getUserName());
            preparedStatement.setString(7,bean.getPassword());
            preparedStatement.setInt(8,bean.getUserID());

             
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
		
	public static List<RegisterBean> view(){
		List<RegisterBean> list=new ArrayList<RegisterBean>();
		try{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("select * from users");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				RegisterBean bean=new RegisterBean();
				bean.setUserID(rs.getInt("userID"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setRole(rs.getString("role"));
				bean.setEmail(rs.getString("Email"));
				bean.setPassword(rs.getString("password"));
				bean.setUserName(rs.getString("UserName"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static RegisterBean viewById(int userID){
		RegisterBean bean=new RegisterBean();
		try{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where userID=?");
			ps.setInt(1,userID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setUserID(rs.getInt(1));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setRole(rs.getString("role"));
				bean.setEmail(rs.getString("Email"));
				bean.setPassword(rs.getString("password"));
				bean.setUserName(rs.getString("UserName"));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int userID){
		int status=0;
		try{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("delete from users where userID=?");
			ps.setInt(1,userID);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

}