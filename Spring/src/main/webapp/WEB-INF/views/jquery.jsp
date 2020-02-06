<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>이미지 보고잇는 중입니다.</h1>
	<h1 id="me">이미지 보고잇는 중입니다.</h1>
	<h1 class = "c">이미지 보고잇는 중입니다.</h1>
	<input id="btn" type=button value="Click Count"><div id="result"></div>
	
	
<!-- 	<img src="http://localhost:8080/mvc/resources/images/google.png"> -->
	<img src="<%=request.getContextPath()%>/resources/images/google.png">
	<script src="<%=request.getContextPath()%>/resources/jquery-3.2.1.min.js"></script>
	<script>
// 		$("h1").css("color", "blue")
// 		$("css selector=선택자").함수명(매개변수);
// 		$("태그명")
// 		$("#id명")
// 		$(".class명")
		$("#me").css("color", "blue");
		$(".c").css("color", "red");

		var cnt = 1;
		$("btn").on('click', function(){
			$("div#result").html("<h3>추가합니다</h3>");
			cnt++;
		});
		
		
	</script>
	
</body>
</html>