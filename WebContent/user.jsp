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
<body ng-app="myApp" ng-controller="UserController">
<div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>User name</th>
                              <th>phone</th>
                              <th>Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in users">
                              <td>{{u.username}}</td>
                              <td>{{u.phone}}</td>
                              <td>{{u.email}}</td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
 <script>
var app = angular.module('myApp',[]);
app.controller('UserController', function($scope, $http) {
	$http.get(CONTEXT_PATH+'welcomes').then(function(response) {
		$scope.users=response.data;
	});
 });
  </script>
</body>
</html>