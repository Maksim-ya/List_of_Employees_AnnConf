
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employees page</title>

</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Employee List</h1>

<c:if test="${!empty listEmployees}">
  <table class="tg">
    <tr>
      <th width="80">ID</th>
      <th width="120">First Name</th>
      <th width="120">Last Name</th>
      <th width="120">Position</th>
      <th width="120">Salary</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listEmployees}" var="employee">
      <tr>
        <td><a href="/employeedata/${employee.id}" target="_blank">${employee.id}</a></td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.position}</td>
        <td>${employee.salary}</td>
        <td><a href="<c:url value='/edit/${employee.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${employee.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>


<h1>Add a Employee</h1>

<c:url var="addAction" value="/employees/add"/>

<form:form action="${addAction}" commandName="employee">
  <table>
    <c:if test="${!empty employee.firstName}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8" disabled="true"/>
          <form:hidden path="id"/>
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="firstName">
          <spring:message text="FirstName"/>
        </form:label>
      </td>
      <td>
        <form:input path="firstName"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="lastName">
          <spring:message text="LastName"/>
        </form:label>
      </td>
      <td>
        <form:input path="lastName"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="position">
          <spring:message text="Position"/>
        </form:label>
      </td>
      <td>
        <form:input path="position"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="salary">
          <spring:message text="Salary"/>
        </form:label>
      </td>
      <td>
        <form:input path="salary"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty employee.firstName}">
          <input type="submit"
                 value="<spring:message text="Edit Employee"/>"/>
        </c:if>
        <c:if test="${empty employee.firstName}">
          <input type="submit"
                 value="<spring:message text="Add Employee"/>"/>
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
