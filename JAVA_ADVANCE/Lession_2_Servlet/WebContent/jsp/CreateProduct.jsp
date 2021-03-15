<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Create product</h3>
	<form action="${pageContext.request.contextPath}/products" method="post">
		Code <input type="text" name="code"> <br> 
		Name <input type="text" name="name"> <br> 
		Price <input type="text" name="price"> <br>
		<button type="submit" name="Submit">Submit</button>
		<button type="reset" name="Cancel">Cancel</button>
	</form>
</body>
</html>