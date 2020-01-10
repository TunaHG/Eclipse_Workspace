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
    <link rel="stylesheet" href="chart.css">
	<link rel="stylesheet" href="https://cdn.rawgit.com/theus/chart.css/v1.0.0/dist/chart.css" />
    
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
      
      #charts{
      width: 1200px;
        padding: 100px;
        float: center;
        font-family: 'Nanum Gothic Coding', monospace;
        font-size:18px;
      }

	#content {
        width: 1239px;
        padding: 20px;
        margin-bottom: 20px;
        float: center;
        font-family: 'Nanum Gothic Coding', monospace;
        font-size:18px;
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
  <li role="presentation"><a href="Pay_manage.jsp">결제관리</a></li>
  <li role="presentation" class="active"><a href="hotel_manage.jsp">호텔관리</a></li>
</ul>
</div>
<div id="content">
<br>
        <h2>UIJO Hotel 연간 실적</h2>
</div>
<table class="table">
<thead>	
	<tr>
		<th>분기</th>
		<th>매출</th>
		<th>영업이익</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td>1Q</td>
		<td>1000000000000</td>
		<td>3000000000</td>
	</tr>
	<tr>
		<td>2Q</td>
		<td>2000000000000</td>
		<td>3000000000</td>
	</tr>
	<tr>
		<td>3Q</td>
		<td>3000000000000</td>
		<td>4000000000</td>
	</tr>
	<tr>
		<td>4Q</td>
		<td>5000000000000</td>
		<td>3000000000</td>
	</tr>
</tbody>
</table>
<div id="charts">
<div class="charts charts--vertical">

  
  <div class="charts__chart chart--p74 chart--xl chart--grey chart--hover">
    <span class="charts__percent">1월</span>
  </div>

  <div class="charts__chart chart--p43 chart--xl chart--grey chart--hover">
    <span class="charts__percent">2월</span>
  </div>

  <div class="charts__chart chart--p40 chart--xl chart--grey chart--hover">
    <span class="charts__percent">3월</span>
  </div>

  <div class="charts__chart chart--p43 chart--xl chart--grey chart--hover">
    <span class="charts__percent">4월</span>
  </div>

  <div class="charts__chart chart--p53 chart--xl chart--grey chart--hover">
    <span class="charts__percent">5월</span>
  </div>
  
  <div class="charts__chart chart--p55 chart--xl chart--grey chart--hover">
    <span class="charts__percent">6월</span>
  </div>

  <div class="charts__chart chart--p89 chart--xl chart--grey chart--hover">
    <span class="charts__percent">7월</span>
  </div>

  <div class="charts__chart chart--p90 chart--xl chart--grey chart--hover">
    <span class="charts__percent">8월</span>
  </div>

  <div class="charts__chart chart--p20 chart--xl chart--grey chart--hover">
    <span class="charts__percent">9월</span>
  </div>

  <div class="charts__chart chart--p48 chart--xl chart--grey chart--hover">
    <span class="charts__percent">10월</span>
  </div>
  
  <div class="charts__chart chart--p63 chart--xl chart--grey chart--hover">
    <span class="charts__percent">11월</span>
  </div>

  <div class="charts__chart chart--p70 chart--xl chart--grey chart--hover">
    <span class="charts__percent">12월</span>
  </div>
</div>
</div>
</body>
</html>