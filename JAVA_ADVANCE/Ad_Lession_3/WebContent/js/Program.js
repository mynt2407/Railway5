$(function() {
	var usernameCookie = getCookie("username");
	
if(!usernameCookie){
	$("a#viewList").hide();
	$("a#login").show();
	$("a#logout").hide();
}
else{
	$("a#viewList").show();
	$("a#login").hide();
	$("a#logout").show();
}
});

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function clickNavihome() {
    $(".main").load("jsp/home.jsp");
}

function clickNaviViewList() {
    $(".main").load("jsp/viewList.jsp");
}
function login() {
   window.location.replace("./login");
}
function logout() {
   window.location.replace("./logout");
}