package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.model.Game;

import app.model.Question;
import app.model.Candidate;


public class Dao {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/election_db", "root", "password");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int saveGame(Game game) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into gametable(breed, weight) values('"+game.getBreed()+"', "+game.getWeight()+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int saveQuestion(Question question) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			final String Questionl =  question.getQuestion();
			count=stmt.executeUpdate("insert into questions(question) values('"+question.getQuestion()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	public ArrayList<Game> readAllGame() {
		ArrayList<Game> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from gametable");
			while (rs.next()) {
				Game game=new Game();
				game.setId(rs.getInt("id"));
				game.setBreed(rs.getString("breed"));
				game.setWeight(rs.getFloat("weight"));
				list.add(game);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Question> readAllQuestion() {
		ArrayList<Question> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from questions");
			while (rs.next()) {
				Question question=new Question();
			question.setQ_id(rs.getInt("q_id"));
				question.setQuestion(rs.getString("question"));
				list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateGame(Game game) {
		int count = 0;
		String sql = "update gametable set breed = ?, weight = ? where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, game.getBreed());
			stmt.setFloat(2, game.getWeight());
			
			stmt.setInt(3, game.getId());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int updateQuestion(Question question) {
		int count = 0;
		String sql = "update questions set question = ? where q_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, question.getQuestion());
			stmt.setInt(3, question.getQ_id());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Game getGameInfo(int id) {
		Game result = null;
		String sql = "select * from gametable where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Game();
				result.setId(resultset.getInt("id"));
				result.setBreed(resultset.getString("breed"));
				result.setWeight(resultset.getFloat("weight"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public void addUser(String username, String pw, String salt){
		String sql = "insert into user (username, hashedpassword, salt) values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);
			
			stmt.executeUpdate();	 
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public Question getQuestionInfo(int q_id) {
		Question result = null;
		String sql = "select * from questions where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, q_id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Question();
				result.setQ_id(resultset.getInt("q_id"));
				result.setQuestion(resultset.getString("question"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String getUserSalt(String username) {
		String result = "";
		String sql = "select salt from user where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("salt");
			}} catch (SQLException e){
				e.printStackTrace();
			}
			return result;}
	public String getUserPasswordHash(String username) {
		String result = "";
		String sql = "select hashedpassword from user where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("hashedpassword");
			}} catch (SQLException e){
				e.printStackTrace();
			}
			return result;}
	public int save(Candidate e){  
        int status=0;  
        try{  
            PreparedStatement stmt = conn.prepareStatement(  
                         "insert into candidates(name,password,email,country) values (?,?,?,?)");  
            stmt.setString(1,e.getName());  
            stmt.setString(2,e.getPassword());  
            stmt.setString(3,e.getEmail());  
            stmt.setString(4,e.getCountry());  
              
            status=stmt.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public int update(Candidate e){  
        int status=0;  
        try{  
            PreparedStatement stmt = conn.prepareStatement(  
                         "update candidates set name=?,password=?,email=?,country=? where id=?");  
            stmt.setString(1,e.getName());  
            stmt.setString(2,e.getPassword());  
            stmt.setString(3,e.getEmail());  
            stmt.setString(4,e.getCountry());  
            stmt.setInt(5,e.getId());  
              
            status=stmt.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public int delete(int id){  
        int status=0;  
        try{  
            PreparedStatement stmt = conn.prepareStatement( "delete from candidates where id=?");  
            stmt.setInt(1,id);  
            status=stmt.executeUpdate();  
              
            conn.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public Candidate getCandidateById(int id){  
    	Candidate e=new Candidate();  
          
        try{  
            PreparedStatement stmt = conn.prepareStatement("select * from candidates where id=?");  
            stmt.setInt(1,id);  
            ResultSet rs=stmt.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public List<Candidate> getAllCandidates(){  
        List<Candidate> list=new ArrayList<Candidate>();  
          
        try{  
        	PreparedStatement stmt = conn.prepareStatement("select * from candidates");  
            ResultSet rs=stmt.executeQuery();  
            while(rs.next()){  
            	Candidate e=new Candidate();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            conn.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}