package com.webService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DBconnection.DBConnect;
import com.entity.TodoEntity;

@WebServlet("/add_todo")
public class AddServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String todo = request.getParameter("todo");
		String status = request.getParameter("status");
		
		TodoEntity entity = new TodoEntity();
		entity.setNameString(username);
		entity.setTodoString(todo);
		entity.setStatuString(status);
		TodoDAO dao = new TodoDAO(DBConnect.getCon());
		boolean f = dao.addTodo(entity);
		
		HttpSession session = request.getSession();
		if(f) {
			response.sendRedirect("index.jsp");
			session.setAttribute("sucmsg", "Todo added Successfully");
		} else {
			response.sendRedirect("index.jsp");
			session.setAttribute("failmsg", "Error Encountered");
		}
		
		
	}

}
