<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding" rel="stylesheet">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <title>CSS</title>
    <style>
    	body{background: url(travel-3135436_640.jpg) repeat-x center top;}
    	.rsvBar {position:absolute; top:260px; left:10px; right:10px; margin:auto;}
	    .rsvBar .rsvBarContent {background:#e2e2e2;}
	    .date_select {width:600px; height:40px;}
	    .selectBox {width:120px; height:40px; margin: 10px;}
	  
	    .quick{text-align:right;}
	    .quick a{display: inline-block; color: #fff; padding: 5px 0 0 10px; transition: all 0.5s ease; font-family: 'Nanum Gothic Coding', monospace;}
	    .quick a:hover {color:#ccc;}  
	  
	    .title{text-align:center; text-transform: uppercase; padding-top: 70px;}
	    .title p{display: inline; font-size:24px; font-family: 'Nanum Gothic Coding', monospace;  color:#fff; padding: 10px 20px;}
	    .title h1 a{display:inline-block; color:#fff;  font-family: 'Nanum Gothic Coding', monospace; padding: 10px 20px; font-size:14px; transition:all .3s ease-in-out; margin-top:-4px;}
	    .title h1 a:hover{
	  	box-shadow:
		0 0 0 3px rgba(75,154,191,0,9) inset,
		0 0 0 100px rgba(0,0,0,0.1) inset;}
		
		
		.menu{}
		.menu li{position:relative;}
		.menu li a{font-size:16px; text-transform:uppercase; color:#878787; border-bottom:1px solid #dbdbdb; padding: 10px; display:block; transition:all .3s ease;}
		.menu li a:hover {color: #333;}
		.menu li a i{position:absolute; right:10px; top:15px;}
		
	  
	  
      #jb-container {
        width: 1280px;
        margin: 0px auto;
        padding: 20px;
        
      }
      #jb-header {
        padding: 30px;
        margin-bottom: 50px;
      }
      #jb-content {
        width: 920px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        font-family: 'Nanum Gothic Coding', monospace;
        font-size:15px;
        border-left:1px solid #dbdbdb;
      }
      #jb-sidebar {
        width: 260px;
        height: 1484px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        font-family: 'Nanum Gothic Coding', monospace;
        font-size:18px;
      }
      .jb-sidebar{}
      .jb-sidebar ul{position:relative;}
      .jb-sidebar ul a{font-size:16px; text-transform:uppercase; color:#878787; border-bottom:1px solid #dbdbdb; padding: 10px; display:block; transition:all .3s ease;}
      .jb-sidebar ul a:hover {color: #333;}
      .jb-sidebar ul a i{position:absolute; right:10px; top:15px;}
      
      .jb-content h2{border-bottom:thick double #666666;}
      
      .jb-footer {
        clear: both;
        text-align:center; padding:30px 50px;
      }
      
      .desc{border-bottom: 1px dashed #dbdbdb; padding-bottom:10px; margin-bottom:10px; color:#878787;}
      
      .jb-footer li {list-style:none; position:relative; display:inline; padding:0 7px; font-size:11px;}
      video{width:100%;}
      
      
      
    </style>
  </head>
  <body>
    <div id="jb-container">
      <div id="jb-header">
		<div class="row">
			<div class="quick">
				<a href="hotelinfo.jsp">호텔소개</a>
				<a href="#">예약<i class="far fa-calendar-alt"></i></a>
				<a href="login_main.jsp">로그인</a>
				<a href="join_main.jsp">회원가입</a>
				<a href="mypage.jsp">마이페이지</a>
			</div>
			<div class="title">
				<p>The Uijo Hotel</p>
				<h1><a href="main.jsp">theuijo.co.kr</a>
				</h1>
			</div>
		</div>
      </div>
      <div id="jb-content">
      	<h2>The Uijo Hotel</h2>
      	<p class="desc"></p>
  		<div class="img1"><img src="pbl2.jpg" alt="이미지" style="width:870px; height:450px;"></div><br>
  		<h2>The Best Hospitality Company</h2>
  		<p class="desc"></p>
  		<p>의조호텔은 '최고의 호스피탈리티 기업'을 목표로 오랜 세월동안 품위와 전통을 유지하며 고객들의 마음을</p>
  		<p>사로잡아 왔습니다. 모던이즘적인 요소를 가미하여 삶의 여유와 </p>
  		<p>품격을 한층 높여주는 프리미엄 라이프 스타일 공간으로 변화를 거듭해 왔습니다.</p>
  		<p>의조호텔은 앞으로도 끊임없는 창조적 혁신과 도전을 바탕으로 차별화된 최상의 가치를 선사하는 글로벌 호</p>
  		<p>스피탈리티 명문 기업으로 성장할 것을 약속드립니다.</p><br>
  		<h2>Vision</h2>
  		<p class="desc"></p>
  		<p>Premium lifestyle leading company</p>
  		<p>최고의 품격과 신뢰를 바탕으로 고객이 꿈꾸는 라이프스타일을 제공하는 글로벌 선도기업</p><br>
  		<h2>Video</h2>
  		<p class="desc"></p>
  		<p>의조호텔은 고객의 편안함을 추구합니다.</p>
  		<div class="video">
  			<video controls="controls" autoplay="autoplay">
  				<source src="css/video.mp4" type="video/mp4">
  			</video>
  		</div>
      </div>
      <div id="jb-sidebar">
        <h2>호텔소개</h2>
        <p class="desc"></p>
        <div class="menu">
        	<ul>
        		<li><a href="hotelinfo.jsp">호텔소개<i class="fas fa-angle-double-right"></i></a></li>
      		    <li><a href="managerinfo.jsp">직원소개<i class="fas fa-angle-double-right"></i></a></li>
      		</ul>
      	</div>
      </div>
      <div class="jb-footer">
      	<ul>
			<li>경기도 안산시 상록구 Hanyang University Erica Campus
			<li>사업자등록번호 123-45-12345
		</ul>
		<address>
			<em>Copyright $copy;
			<a href="#"><strong>TheUijoHotel</strong></a>
			All Rights Reserved.</em>
		</address>
      </div>
      <div class="rsvBar">
			<div class="rsvBarContent">
				<!--checkIn   : year,month,day // list -->
				<span class="date_select">
					<select class="selectBox" id="in_year" onchange="addMonth('in')">
					<option value="2018">2018</option><option value="2019">2019</option></select>
					<select class="selectBox" id="in_month" onchange="addDay('in')">
						
					<option value="11">11</option><option value="12">12</option></select>
					<select class="selectBox" id="in_day">
						
					<option value="28">28</option><option value="29">29</option><option value="30">30</option></select>
				</span>
				
				<!--checkOut  : year,month,day // list -->
				<span class="date_select">
					<select class="selectBox" id="out_year" onchange="addMonth('out')">
					<option value="2018">2018</option><option value="2019">2019</option></select>
					<select class="selectBox" id="out_month" onchange="addDay('out')">
						
					<option value="11">11</option><option value="12">12</option></select>
					<select class="selectBox" id="out_day">
						
					<option value="28">28</option><option value="29">29</option><option value="30">30</option></select>
				</span>
				
				<!--peopleNum : adult, child   // list -->
				<span class="peopleNum_select">
					<select class="selectBox" name="people" id="adlt_select">
						<option value="0">adult</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
					<select class="selectBox" name="people" id="chld_select">
						<option value="0">child</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="2">3</option>
						<option value="2">4</option>
					</select>
				</span>
				
				<!-- check button -->
				<button style="width:80px; height:40px; margin:10px;" onclick="addReservation()">search</button>
			</div>
		</div>
    </div>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
  </body>
</html>