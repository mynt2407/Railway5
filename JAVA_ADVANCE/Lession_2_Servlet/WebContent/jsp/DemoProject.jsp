<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

</style>


</head>
<body>
	<!-- header -->
	<div class="header">
		<jsp:include page='searchBar.jsp'></jsp:include>
	</div>
<!-- main -->
	<div class="main">
		<jsp:include page='home.jsp'></jsp:include>
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