package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.model.Question;

/*
 * The name of the servlet is AddGame
 * and the servlet's URI (url-pattern) is 'addgame'
 */
@WebServlet(
		name = "AddQuestion",
		urlPatterns = {"/addquestion"}
		)
public class AddQuestion extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * If the request type is POST, the request is transferred to the method doGet
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		/*
		 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		 */
		RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		rd.include(request,  response);;
		
		// Read parameters to Model
		Question question=readQuestion(request);
	
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.saveQuestion(question);
		ArrayList<Question> list=dao.readAllQuestion();
		
		// print output and close connection
		printQuestionList(out, list);
		dao.close();
		
		
		out.println("<br><a href='./form.html'>Back to form</a>");

		/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 */
		rd=request.getRequestDispatcher("staticpages/htmlend.html");
		rd.include(request,  response);;
	}


	private Question readQuestion(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Question question=new Question();
		question.setQuestion(request.getParameter("question"));
		return question;
	}
	
	private void printQuestionList(PrintWriter out, ArrayList<Question> list) {
		out.println("<ul>");
		for (Question g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}