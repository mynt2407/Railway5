
<!DOCTYPE html>
<%@page import="com.vti.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.vti.presentation.ProductController"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Project</title>

<!-- import JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!--import Bootstrap  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<!-- import css -->
<style type="text/css">
<jsp:include page = "../css/searchBar.css"/>
table, th, td {
	border: 1px solid black
}
</style>



</head>

<body>
	<!-- header -->
	<div class="header">
		<jsp:include page='searchBar.jsp'></jsp:include>
	</div>
	<!-- main -->
	<div class="main">
		<%
		ProductController productController = new ProductController();
		List<Product> products = productController.getListProducts();
		%>
		<table>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<%
				for (Product product : products) {
			%>
			<tr>
				<td><%=product.getCode()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getPrice()%></td>
				<td><u>Edit</u></td>
				<td><u>Delete</u></td>
			</tr>
			<%
				}
			%>
		</table>
		
		<br> <br> 
		<a onclick="clickCreateProduct()"><u>Create Product</u></a>
	</div>

	<!-- footer -->
	<div class="footer">
		<jsp:include page='footer.jsp'></jsp:include>
	</div>
	
</body>


<script>
	<jsp:include page="../js/program.js"/>
</script>
</html>




