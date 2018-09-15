<%@page import="lti.quiz.bean.OptionBean"%>
<%@page import="lti.quiz.bean.QuizBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Page</title>
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
				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-log-in"></span> Login
				</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- <div class="container" align="right">
	<a href="login.jsp"> <input type="button" value="Login">
	</a>
	<a href="register.jsp"> <input type="button" value="Register">
	</a>
	</div> -->
	<div class="container" style="margin-top: 100px">
		<jsp:include page="banner.jsp"></jsp:include>
		<h1>Take the quiz</h1>
		<%
			QuizBean quiz = (QuizBean) request.getAttribute("Question");
		%>
		<form action="quiz.quiz">
			<h4><%=quiz.getQuestion()%></h4>

			<%
				for (OptionBean option : quiz.getOption()) {
			%>
			<input type="radio" name="choice" value="<%=option.getScore()%>"><%=option.getOption()%><br>
			<%
				}
			%>
			<input type="submit" value="Submit Answer" class="btn btn-info">
		</form>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>