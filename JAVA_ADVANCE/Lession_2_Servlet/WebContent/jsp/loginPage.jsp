<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>

<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		Enter your usename <input type="text" name="username"> <br>
		Enter your password <input type="password" name="password"> <br>
		<input type="submit" value="Login">
	</form>
</body>
</html>