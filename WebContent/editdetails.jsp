<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="/SpringCRUD/editdetail" modelAttribute="command">    
<table border="1" width="50%" height="50%"> 
<tr>    
          <td>Phone : </td>   
          <td><form:input path="phone" /></td>  
          
           </tr> 
           <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>      
           
</table>
 </form:form>    
</body>
</html>