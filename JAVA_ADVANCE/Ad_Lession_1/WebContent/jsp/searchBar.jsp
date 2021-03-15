<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<a class="active" onclick="clickNavihome()">Home</a> 
		<a href="#productList" onclick="clickNaviViewList()">Product List</a> 
		<a href="#myinform">My account inform</a> 
		<a href="#Login" onclick="window.location.href ='http://localhost:8080/Lession2_Version2/login'">Login</a>

		<div class="search-container">
			<form action="/action_page.php">
				<input type="text" placeholder="Search.." name="search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>
</body>
</html>