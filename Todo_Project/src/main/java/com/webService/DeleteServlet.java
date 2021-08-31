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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		TodoDAO dao = new TodoDAO(DBConnect.getCon());
		
		boolean f = dao.deleteTodo(id);
		HttpSession session = req.getSession();
		if(f) {
			resp.sendRedirect("index.jsp");
			session.setAttribute("sucmsg", "Todo Deleted Successfully");
		}
		else {
			resp.sendRedirect("index.jsp");
			session.setAttribute("failmsg", "Error Encountered");
		}
	}
	
}
