<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
 <form action="UserListCtl" method="post">
      <h1 align="center">USERLIST</h1>
      
      
 <a href="UserRegistrationCtl">
      <h1> <font color = "green"></font>ADDUSER</h1> </a>
      
      <jsp:useBean id="dto" class="com.rays.dto.UserDto" scope="request"></jsp:useBean>
    
    <%
    
         int pageNo = (Integer)request.getAttribute("pageNo");
         int pageSize = (Integer)request.getAttribute("pageSize");
        List list = (List)request.getAttribute("list");
        
        int index = (pageNo - 1)* pageSize + 1;
        
      Iterator <UserDto>it = list.iterator();
         %>
         
         <label>FIRSTNAME</label><input type="text" name = "firstName" >
         <%-- value = "<%=request.getParameter("firstName")%>"> --%>
       &emsp;
         <label>LASTNAME</label><input type="text" name = "lastName" >
        <%--  value = "<%=request.getParameter("lastName")%>">> --%>
         
         
        
          
          
         <table border="1" style="width: 100%; border: orange;">
         <tr style="background-color: #ele6fle3;">
         
        <th width="5%">Select</th>
         <th width="5%">S.NO.</th>
         <th width ="13%">FirstName</th>
         <th width="13%">LastName</th>
         <th width="13%">LoginId</th>
         <th width="13%">Password</th>
         <th width="8%">Address</th>
         <th width="8%">Edit</th>
         </tr>
         
         <%
             while(it.hasNext()){
            	 
             dto = it.next();
             
             %>
             <body>
           
                <tr>
                 <td> <input type="checkbox" name="id" value="<%=dto.getId()%>"> 
                   <td><%=index++%></td>
                   <td><%=dto.getFirstName()%></td>
                   <td><%=dto.getLastName()%></td>
                   <td><%=dto.getLogin()%></td>
                   <td><%=dto.getPassword()%></td>
                   <td><%=dto.getAddress()%></td>
                   <td><a href="UserCtl?id=<%=dto.getId()%>">edit</a></td>
                   
                   </tr>
                   </body>
          
        
         <%
         
            }
            
            %>
              <input type="submit" name = "operation" value = "search">
              
            &emsp;
             <input type="submit" name="operation" value="DELETE">
            </table>
             
         </form>
</body>
</html>