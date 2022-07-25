<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%--  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body>
    <div id="table root">
        <table>
            <thead>
                <tr>
                    <th>Doctor Id</th>
                    <th>Doctor Name</th>
                    <th>DOB</th>
                    <th>Speciality</th>
                    <th>City</th>
                    <th>Phone Number</th>
                    <th>Standard Fees</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doctor" items="${alldoctors}">
                    <tr>
                        <td>${doctor.id}</td>
                        <td>${doctor.name}</td>
                        <td>${doctor.dob}</td>
                        <td>${doctor.speciality}</td>
                        <td>${doctor.city}</td>
                        <td>${doctor.phone_no}</td>
                        <td>${doctor.standard_fees}</td>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>