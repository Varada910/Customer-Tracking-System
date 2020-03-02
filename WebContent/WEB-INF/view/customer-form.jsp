<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>

<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css"/>

<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>	
<body>

<div id="wrapper">
<div id="header">
<h2>CRM-Customer relationship manager</h2>
</div>
</div>
<div id="container">
<h3>Add Customer</h3>
<form:form action="saveCustomer" modelAttribute="customer" method="post">
<form:hidden path="id"/>
<table>

<tr>
<td>First Name  </td>
<td><form:input path="firstName"/>
</tr>

<tr>
<td>Last Name  </td>
<td><form:input path="lastName"/>
</tr>

<tr>
<td>Email </td>
<td><form:input path="email"/>
</tr>

</table>

<input type="submit" value="submit"/>

</form:form>

<div style="clear;both;"></div>

<p>
<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
</p>
</div>

</body>


</html>