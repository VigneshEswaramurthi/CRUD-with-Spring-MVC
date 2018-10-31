<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome pages</title>
<link rel="stylesheet" href="bootstrap.min.css">
  <script type="text/javascript" src="jquery.min.js"></script>
  <script type="text/javascript" src="bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  <script>var CONTEXT_PATH = '<%=request.getContextPath()%>/';</script>
  <script src="http://ui-grid.info/release/ui-grid.js"></script>
<link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="externalcss.css" rel="stylesheet" type="text/css" />
  </head>
<body>
   <table border="1" width="50%" height="50%"> 
    <tr><th>username</th><th>phone</th><th>email</th><th>Delete</th><th>edit</th><tr>
    <c:forEach var="userBean" items="${user}">   
	<tr> 
	<td>${userBean.username}</td>
     <td>${userBean.phone}</td>
     <td>${userBean.email}</td>
     <td><a href="delete/${userBean.username}">Delete</a></td>
     <td>
     <a href="update/${userBean.username}">Edit</a>
     </td>
     </tr>
       </c:forEach>  	
    </table>
</body>
</html>