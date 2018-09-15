
<!DOCTYPE html>
<html>

<head>
<title>Test Form</title>
<!-- <style>
        tr:nth-child(even) {background-color: rgb(150, 253, 248);}
    </style> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css" />
<script type="text/javascript" src="bootstrap.min.js"></script>



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
	<div class="container" style="margin-top: 100px">
	<jsp:include page="banner.jsp"></jsp:include>
		<form action="user.quiz">
			<fieldset>
				<h1>Registration Form</h1>
				<div id="div_table">
					<table class="table table-striped table-hover">
						<tr>
							<td>Enter Email Id</td>
							<td><input type="text" name="email"></td>
						</tr>
						<tr>
							<td>Enter Password</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td>(Security Question) Who is your favorite super-hero ?</td>
							<td><input type="password" name="secque"></td>
						</tr>
						<tr>

							<td><input type="submit" value="Submit"
								class="btn btn-success"></td>
							<td></td>
						</tr>

					</table>
				</div>
			</fieldset>
		</form>
		</div>
		<%@ include file="footer.html"%>
</body>

</html>