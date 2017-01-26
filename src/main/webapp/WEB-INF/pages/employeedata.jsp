
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
  <title>EmployeeData</title>



</head>
<body>
<h1>Employee Details</h1>

<table class="tg">
  <tr>
    <th width="80">ID</th>
    <th width="120">First Name</th>
    <th width="120">Last Name</th>
    <th width="120">Position</th>
    <th width="120">Salary</th>
  </tr>
  <tr>
    <td>${employee.id}</td>
    <td>${employee.firstName}</td>
    <td>${employee.lastName}</td>
    <td>${employee.position}</td>
    <td>${employee.salary}</td>
  </tr>
</table>
</body>
</html>