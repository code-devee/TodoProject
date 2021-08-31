<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Todo</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color:#f0f1f2;">
	<%@include file="component/navbar.jsp"%>

	<h2 class="text-center text-info">Add Todo</h2>

	<div class="container">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-body">
					<form action="add_todo" method="post">
					<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">
								Name </label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" name="username">

						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">TODO
								Name </label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" name="todo">

						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Status
								 </label>
							<select class="form-select" aria-label="Default select example" name="status">
								<option value="selected">--Select--</option>
								<option value="pending">Pending</option>
								<option value="complete">Complete</option>
							</select>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>