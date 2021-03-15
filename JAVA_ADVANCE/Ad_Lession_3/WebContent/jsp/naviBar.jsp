
<%! String getStringAttribute(HttpServletRequest request, String key){
	return request.getAttribute(key)== null? null : request.getAttribute(key).toString();
}  
%>
<%! String fillStringtoValueForm(String value){
	return value == null ? "": value;
}  
%>

<%String username = getStringAttribute(request, "username");
System.out.println(username);
%>

	<%! private String getCookieBykey(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}
	%>
<ul>
	<li><a id="home" href="#home" onclick="clickNavihome()">Home</a></li>
	<li><a id="viewList" href="#view" onclick="clickNaviViewList()">View List</a></li>
	<li style="float: right"><a class="active" id="login" href="#about" onclick="login()">Login</a></li>
	<li style="float: right"><a class="active" id="logout" href="#about" onclick="logout()">Logout</a></li>
	<span style="float: right"><%= fillStringtoValueForm(username)%></span>
</ul>
