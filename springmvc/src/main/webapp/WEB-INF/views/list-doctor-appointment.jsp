<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="root">
		<div id="docform">
			<form:form action="" method="post" modelAttribute="getdoc">
				<div>
					<label for="id">Doctor Id</label>
					<div>
						<form:input path="id" readonly="true" />
					</div>
				</div>
				<div>
					<label for="name">Doctor Name</label>
					<div>
						<form:input path="name" readonly="true" />
					</div>
				</div>
				<div>
					<label for="dob">Date of birth</label>
					<div>
						<form:input path="dob" readonly="true" />
					</div>
				</div>
				<div>
					<label for="speciality">Speciality</label>
					<div>
						<form:input path="speciality" readonly="true" />
					</div>
				</div>
				<div>
					<label for="city">City</label>
					<div>
						<form:input path="city" readonly="true" />
					</div>
				</div>
				<div>
					<label for="phone_no">Phone number</label>
					<div>
						<form:input path="phone_no" readonly="true" />
					</div>
				</div>
				<div>
					<label for="standard_fees">Standard Fees</label>
					<div>
						<form:input path="standard_fees" readonly="true" />
					</div>
				</div>
			</form:form>
		</div>
		<div id="applist">
		<table>
            <thead>
                <tr>
                    <th>APPOINT_ID</th>
                    <th>APPOINT_DATE</th>
                    <th>ID</th>
                    <th>PATIENT_NAME</th>
                    <th>FEES_COLLECTED</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="app" items="${applist}">
                    <tr>
                        <td>${app.appoint_id}</td>
                        <td>${app.appoint_date}</td>
                        <td>${app.id}</td>
                        <td>${app.patient_name}</td>
                        <td>${app.fees_collected}</td>
                </c:forEach>
            </tbody>
        </table>
		</div>
	</div>
</body>
</html>
