<%@page import="lti.quiz.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css" />
<script type="text/javascript" src="bootstrap.min.js"></script>
<title>Banner</title>
</head>
<body style="background-color: WhiteSmoke">
	<h1>ShazamQuiz.com >> Invoke your inner hero.</h1>

	<%
		RegisterBean user = (RegisterBean) session.getAttribute("USER");
		if (user != null) {
	%>
	<div>
		Welcome
		<%=user.getEmail()%>
		| <a href="user.quiz?logout=yes">logout</a>
	</div>
	<%
		} else {
	%>
	<div>Welcome guest</div>
	<%
		}
	%>
	
</body>
</html>