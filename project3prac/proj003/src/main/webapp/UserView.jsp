<%@page import="com.rays.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserCtl" method="post">

		<jsp:useBean id="dto" class="com.rays.dto.UserDto" scope="request"></jsp:useBean>

		<%
			dto = (UserDto) request.getAttribute("dto");
			int id = Integer.parseInt(request.getParameter("id"));
		%>
		<br>
		<th>FIRSTNAME</th> <input type="text" name="firstName"
			value="<%=dto.getFirstName()%>"> 
			</br> <br> <br>
		<th>LASTNAME</th> <input type="text" name="lastName"
			value="<%=dto.getLastName()%>"> 
			</br> <br> <br>
		<th>LOGIN</th> <input type="text" name="login"
			value="<%=dto.getLogin()%>">
			 </br> <br> <br>
		<th>PASSWORD</th> <input type="text" name="password"
			value="<%=dto.getPassword()%>">
			 </br> <br> <br>
		<th>ADDRESS</th> <input type="text" name="address"
			value="<%=dto.getAddress()%>"> 
			</br> <br> <br> 
			
		<input	type="submit" name="operation" value="UPDATE">


  
			<input type="hidden" name="id" value=<%=id%>> 

	</form>

</body>
</html>