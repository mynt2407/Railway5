<%@page import="com.vti.controller.ProductController"%>
<%@page import="com.vti.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
table, th, td {
	border: 1px solid black;
}
</style>

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
	
	<%for(Product product: products){ %>
		<tr>
			<td><%=product.getCode()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%></td>
			<td><u>Edit</u></td>
			<td><u>Delete</u></td>
		</tr>
	<%} %>
</table>
<br>
<br>
<a onclick="clickCreateProduct()"><u>Create Product</u></a>