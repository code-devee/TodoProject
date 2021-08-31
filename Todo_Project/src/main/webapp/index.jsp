<%@page import="com.entity.TodoEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DBconnection.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="component/all_css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%-- <%
		for checking the connection is right or wrong
		Connection conn = DBConnect.getCon();
		out.print(conn);
	%> --%>

	<h2 class="text-center text-info">TODO-APP</h2>
	<%
	String suc = (String) session.getAttribute("sucmsg");
	if (suc != null) {
	%>
	<div class="alert alert-success" role="alert">
		<%=suc%></div>
	<%
	session.removeAttribute("sucmsg");
	}
	%>

	<%
	String fail = (String) session.getAttribute("failmsg");
	if (fail != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=fail%></div>
	<%
	session.removeAttribute("failmsg");
	}
	%>
	<div class="container">
		<table class="table table-striped" border="2px">
			<thead class="bg-info text-white">
				<tr>
					<th scope="col">Sl.no</th>
					<th scope="col">Name</th>
					<th scope="col">Todo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				
				<%
					TodoDAO dao = new TodoDAO(DBConnect.getCon());
					List<TodoEntity> todo = dao.getList();
					for(TodoEntity t : todo) {
				%>
					<tr>
						<th scope="row"><%=t.getId() %></th>
						<th scope="col"><%=t.getNameString() %></th>
						<td><%=t.getTodoString() %></td>
						<td><%=t.getStatuString() %></td>
						<td><a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
						 <a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a></td>
					</tr>
				<% 
					}
				%>
			
			</tbody>

		</table>
	</div>


</body>
</html>