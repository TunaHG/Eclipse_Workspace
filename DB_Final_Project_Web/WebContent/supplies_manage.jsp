<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding" rel="stylesheet">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <link rel="stylesheet" href="css/owl.theme.css">
<title>uijo hotel</title>
<style>
       .page-header {
        padding:8px;
        font-family: sans-serif;
        color:white;
        background : #7B7979;
      }
      
      .menu {
        padding: 20px,20px;
        font-family: 'Nanum Gothic Coding', monospace;
        font-size:12px;
        background :#CFCBCB; 
      }
        </style>
</head>
<body>
<div class="page-header">
  <h4>호텔 관리 시스템 </h4>
</div>
<div class="menu">
 <ul class="nav nav-tabs">
  <li role="presentation"><a href="staff_main.jsp">예약관리</a></li>
  <li role="presentation"><a href="room_manage.jsp">객실관리</a></li>
  <li role="presentation"><a href="request_manage.jsp">요청관리</a></li>
  <li role="presentation"><a href="staff_manage.jsp">직원관리</a></li>
  <li role="presentation" class="active"><a href="supplies_manage.jsp">비품관리</a></li>
  <li role="presentation"><a href="client_manage.jsp">고객관리</a></li> 
  <li role="presentation"><a href="Pay_manage.jsp">결제관리</a></li>
  <li role="presentation"><a href="hotel_manage.jsp">호텔관리</a></li>
</ul>
</div>
<table class="table">
<thead>
	<tr>
		<th>품목</th>
		<th>총 수량</th>
		<th>사용 가능 수량</th>
		<th>객실 배정 수량</th>
		<th>공급업체</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td>수건</td>
		<td>1000</td>
		<td>200</td>
		<td>800</td>
		<td>cj</td>
	</tr>
	<tr>
		<td>냉장고</td>
		<td>100</td>
		<td>30</td>
		<td>70</td>
		<td>LG</td>
	</tr>
	<tr>
		<td>TV</td>
		<td>150</td>
		<td>30</td>
		<td>120</td>
		<td>삼성</td>
	</tr>
	<tr>
		<td>베게</td>
		<td>800</td>
		<td>200</td>
		<td>600</td>
		<td>cj</td>
	</tr>
	<tr>
		<td>테이블</td>
		<td>400</td>
		<td>30</td>
		<td>370</td>
		<td>iloom</td>
	</tr>
	<tr>
		<td>에어컨</td>
		<td>100</td>
		<td>30</td>
		<td>70</td>
		<td>LG</td>
	</tr>
</tbody>
</table>
<nav>
  <ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</nav>
</body>
</html>