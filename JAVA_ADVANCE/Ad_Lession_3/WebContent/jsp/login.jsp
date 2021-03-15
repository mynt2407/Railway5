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

<style type="text/css">
<jsp:include page="../css/main.css"/>
<jsp:include page="../css/program.css"/>
<jsp:include page="../css/navibar.css"/>
<jsp:include page="../css/table.css"/>
<jsp:include page="../css/registerform.css"/>
</style>

</head>

<body>
<%! String getStringAttribute(HttpServletRequest request, String key){
	return request.getAttribute(key)== null? null : request.getAttribute(key).toString();
}  
%>
<%! String fillStringtoValueForm(String value){
	return value == null ? "": value;
}  
%>

<%String username = getStringAttribute(request, "username");
String messageErorr = getStringAttribute(request, "messageErorr");
System.out.println(username);
%>
<h2>Login Form</h2>
<p style="color:red"><%= fillStringtoValueForm(messageErorr) %></p>
<form action="${pageContext.request.contextPath}/login" method="post">
  <div class="imgcontainer">
    <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required
    value ="<%= fillStringtoValueForm(username) %>"
    >

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>

</body>

<!-- Import javascript -->
<script>
	<jsp:include page='../js/login.js'></jsp:include>
</script>

</html>
