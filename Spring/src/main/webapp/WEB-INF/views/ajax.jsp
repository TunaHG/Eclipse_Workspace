<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="/mvc/ajaxlogin">
		아이디<input type=text name="id" id="id"><br>
		암호<input type="password" name="pw" id="pw"><br>
		<input type="submit" value="Login">
		<input id="ajaxbtn" type="button" value="AjaxLogin">
	</form>
	
	<div>
	
	</div>
	<img src="/mvc/resources/images/google.png"><br>
	
	<script src="/mvc/resources/jquery-3.2.1.min.js"></script>
	<script>
		$("#ajaxbtn").on("click", function(){
			$.ajax({
				url:'/mvc/ajaxlogin2',
				data: {"id": $("#id").val(), "pw" : $("#pw").val()},
				type: 'get',
				dataType: 'json',
				success:function(serverdata){
					// {"status":true, "time": "2020년 2월 ..."}
					$("div").html(serverdata.status + " - " + serverdata.time);
					$("div").css("color", "red");
					$("div").css("border", "2px solid blue");
				}
			}); // ajax end
		}); // on end
	</script>
	
	<input type="text" id="seq">
	<input type="button" id="ajaxboardbtn" value="게시물 1개만 주세요">
	<div id="boarddiv"></div>
	<script>
		$("#ajaxboardbtn").on("click", function(){
			$.ajax({
				url:'/mvc/ajaxboard',
				data: {"seq":$("#seq").val()},
				type: 'get',
				dataType: 'json',
				success:function(serverdata){
					$("#boarddiv").html(serverdata.seq + " - " + serverdata.title + " - " + serverdate.contents + " - -" +
							serverdata.writer + " - " + serverdata.time + " - " + serverdata.viewcount + "<br>");
					$("#boarddiv").css("color", "red");
					$("#boarddiv").css("border", "2px solid blue");
				}
			}); // ajax end
		}); // on end
	</script>
</body>
</html>