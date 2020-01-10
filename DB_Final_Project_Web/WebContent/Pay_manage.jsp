<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="client.PayDTO"%>
<%@page import="client.PayDAO"%>
<%
	PayDAO manager = PayDAO.getInstance();
	List<PayDTO> list = manager.getList();
	PayDTO data = new PayDTO();
%>
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
  <li role="presentation"><a href="supplies_manage.jsp">비품관리</a></li>
  <li role="presentation"><a href="client_manage.jsp">고객관리</a></li> 
  <li role="presentation" class="active"><a href="Pay_manage.jsp">결제관리</a></li>
  <li role="presentation"><a href="hotel_manage.jsp">호텔관리</a></li>
</ul>
</div>
<table class="table">
<thead>	
	<tr>
		<th>No.</th>
		<th>고객 연락처</th>
		<th>결제 물품</th>
		<th>결제 비용</th>
		<th>담당직원</th>
		<th>결제시간</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
</thead>
<%
	for(int i = 0; i < list.size(); i++){
		data = list.get(i);
	
%>
<tbody>
	<tr class="warning">
		<td><%=data.getNo()%></td>
		<td><%=data.getPhone()%></td>
		<td><%=data.getItem()%></td>
		<td><%=data.getPrice()%></td>
		<td><%=data.getRespond()%></td>
		<td><%=data.getReg_date()%></td>
		<td><a href="Pay_Update_Form.jsp?no=<%=data.getNo()%>">수정</a></td>
		<td><a href="Pay_Delete.jsp?no=<%=data.getNo()%>">삭제</a></td>
	</tr>
	<%} %>
	<tr>
		<td colspan="8" align="right"><input type="button" value="결제 등록" onclick="location.href='Pay_Add_Form.jsp'"></td>
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