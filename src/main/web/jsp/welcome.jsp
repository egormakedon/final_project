<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
	<head>
		<title>Welcome</title>

		<link rel="shortcut icon" href="../images/pageLogo.png" type="image/png">
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
		<link href="../css/default.css" rel="stylesheet" type="text/css" media="all" />
		<link href="../css/fonts.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>
		<div id="header-wrapper">
			<div id="header" class="container">
				<div id="logo">
					<h1><a href="welcome.jsp">Selection Committee</a></h1>
				</div>
				<div id="menu">
					<ul>
						<li><a href="login.jsp" accesskey="1" title="">Login</a></li>
						<li><a href="registration.jsp" accesskey="2" title="">Registration</a></li>
					</ul>
				</div>
			</div>
		</div>
		<img src="../images/banner.png" style="width: 100%; height: 100%">
		<form id="copyright" class="container" action="/Controller" method="get">
			<input type="hidden" name="command" value="epamlink">
			<p>&copy; 2018. CREATED BY EGOR MAKEDON FOR EPAM SYSTEMS. <input class="ignore-css" type="submit" value="epam.by" style="color: white; background: #2b2b2b"> All rights reserved.</p>
		</form>
	</body>
</html>