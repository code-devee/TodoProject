<%@page import="com.DBconnection.DBConnect"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.entity.TodoEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Todo</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color:#f0f1f2;">
	<%@include file="component/navbar.jsp"%>

	<h2 class="text-center text-info">Edit Todo</h2>
	
	<div class="container">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-body">
				<%
					int id = Integer.parseInt(request.getParameter("id"));
					TodoDAO dao = new TodoDAO(DBConnect.getCon());
					TodoEntity t = dao.getById(id);
		
				%>
					<form action="edit" method="post">
					<div class="mb-3">
							<input type="hidden" name="id" value="<%=t.getId() %>">
					
							<label for="exampleInputEmail1" class="form-label">
								Name </label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" name="username" value="<%=t.getNameString()%>">

						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">TODO
								Name </label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" name="todo" value="<%=t.getTodoString() %>">

						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Status
								 </label>
							<select class="form-select" aria-label="Default select example" name="status">
							<%
							if("Pending".equals(t.getStatuString())) {
							%>
								<option value="pending">Pending</option>
								<option value="complete">Complete</option>
							<%
							}else{
							%>
								<option value="complete">Complete</option>
								<option value="pending">Pending</option>
							<%	
							}
							%>
							
								
							</select>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>

	
</body>
</html>