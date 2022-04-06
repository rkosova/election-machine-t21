package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Question;

@WebServlet(
		name = "EditQuestionServlet",
		urlPatterns = {"/editquestion"}
		)
public class EditQuestionServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("q_id");
		
		if ( idValue != null ) {
			try {
				int q_id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Question question = dao.getQuestionInfo(q_id);
				
				session.setAttribute("question", question);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editform.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showdata");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Question question = readQuestion(request);
		
		dao.updateQuestion(question);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showdata");
	}
	
	private Question readQuestion(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Question question=new Question();
		question.setQuestion(request.getParameter("question"));
		question.setQ_id(Integer.parseInt(request.getParameter("id")));
		return question;
	}
}


