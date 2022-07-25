<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="findemployeebyid">
				<div>
					<label for="emp_id">Employee Id</label>
					<div>
						<form:input path="emp_id" readonly="true" />
					</div>
				</div>
				<div>
					<label for="first_name">First Name</label>
					<div>
						<form:input path="first_name" readonly="true" />
					</div>
				</div>
				<div>
					<label for="last_name">Last Name</label>
					<div>
						<form:input path="last_name" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" readonly="true" />
					</div>
				</div>
				<div>
					<label for="hire_date">Hire Date</label>
					<div>
						<form:input path="hire_date" readonly="true" />
					</div>
				</div>
				<div>
					<label for="job_id">Job Id</label>
					<div>
						<form:input path="job_id" readonly="true" />
					</div>
				</div>
				<div>
					<label for="salary">Salary</label>
					<div>
						<form:input path="salary" readonly="true" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>