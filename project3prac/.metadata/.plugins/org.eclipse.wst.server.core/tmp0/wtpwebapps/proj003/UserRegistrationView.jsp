<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UserRegistrationCtl" method="post">

<br><br><br><br><br>

<div align="center">
<center>
  <a href="UserListCtl">
  <h1> <font color = "green"></font>USERLIST</h1></a>
  </center>
   <h1>User Registration</h1>
   <table>
         
         <tr>
         <br>
            <div>
                 <label>FirstName</label>
                 <input type="text" name="firstName" placeholder="Enter First Name" >
                 
                 </div>
   
                 <br> <div>
                  <label>LastName<label>
                  <input type="text" name  ="lastName" placeholder="Enter Last Name">
                  
                  </div>
                  
                <br>  <div>
                  <label>Login</label>
                  <input type="text" name ="login" placeholder="Enter LoginId">
                  </div>
                  
                <br>  <div>
                  <label>Password</label>
                  <input type="text" name ="password" placeholder="Enter Password">
                  </div>
                  
               <br>   <div>
                  <label>Address</label>
                  <input type="text" name = "address" placeholder="Enter Address">
                  </div>
                
             <br>   <div class = "text-center">
                
                
                   <input type=submit name = "operation" value =SignUp>
                   
                   </div>
                   </tr>
   </table>

</div>
</form>
</body>
</html>