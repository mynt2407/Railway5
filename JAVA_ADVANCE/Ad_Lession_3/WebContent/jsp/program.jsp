<!DOCTYPE html>
<html lang="en">

<head>
<title>Employee Management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- import J Query  -->
<!-- Lưu ý: inmport J Query trước khi import bootstrap -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- import bootstrap -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
	<!-- import css -->
	
<style type="text/css">
<jsp:include page='../css/main.css'/>
<jsp:include page='../css/program.css'/>
<jsp:include page='../css/navibar.css'/>
<jsp:include page='../css/table.css'/>
<jsp:include page='../css/registerform.css'/>
</style>

</head>

<body>

	<div class="header">
		<jsp:include page='naviBar.jsp'></jsp:include>
	</div>
	
	<div class="main">
		<jsp:include page='home.jsp'></jsp:include>
	</div>

	<div class="footer">
		<jsp:include page='footer.jsp'></jsp:include>
	</div>

</body>

<!-- Import javascript -->
<script>
	<jsp:include page='../js/Program.js'></jsp:include>
</script>

</html>