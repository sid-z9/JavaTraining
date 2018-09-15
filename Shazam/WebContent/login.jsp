<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="home.jsp">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="register.jsp"> <span
							class="glyphicon glyphicon-user"></span> Sign Up
					</a></li>
					<!-- <li><a href="login.jsp"> <span
							class="glyphicon glyphicon-log-in"></span> Login
					</a></li> -->
				</ul>
			</div>
		</div>
	</nav>
	<div style="width:30%; margin-top: 100px">
	<jsp:include page="banner.jsp"></jsp:include>
	<h1>Login screen</h1>
	<hr>
	<%
		if (request.getParameter("invalid") != null) {
	%>
	<div class="alert-danger">Invalid User ID/Password</div>
	<%
		}
	%>
	
	<form action="user.quiz">
		<table class="table table-striped table-hover">
			<tr>
				<td>Email Id :</td>
				<td><input name="email" class="btn btn-default"><br>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					class="btn btn-default"><br></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" class="btn btn-primary">
				</td>
				<td><!-- <a href="register.jsp"> <input type="button"
						value="Register" class="btn btn-default">
				</a> <br> --></td></tr>
			<tr>
			<td>
				<a href="forget.jsp"> Forgot Password ? </a>
				</td>
				<td></td>
				</tr>
				
		</table>

	</form>
</div>
<!-- Static inclusion Directive-->
<%@ include file="footer.html" %>
</body>
</html>