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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String todo = request.getParameter("todo");
		String status = request.getParameter("status");
		
		TodoDAO dao = new TodoDAO(DBConnect.getCon());
		
		TodoEntity entity = new TodoEntity();
		entity.setId(id);
		entity.setNameString(username);
		entity.setTodoString(todo);
		entity.setStatuString(status);
		
		boolean f = dao.editTodo(entity);
		HttpSession session = request.getSession();
		if(f) {
			response.sendRedirect("index.jsp");
			session.setAttribute("sucmsg", "Todo Updated Successfully");
		}else {
			response.sendRedirect("index.jsp");
			session.setAttribute("failmsg", "Error Encountered");
		}
	}

}
