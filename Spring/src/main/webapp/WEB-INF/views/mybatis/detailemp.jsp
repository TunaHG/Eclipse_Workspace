<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>선택한 사원의 정보입니다.</h1>
	사번 : ${vo.employee_id}<br>
	이름과 성 : ${vo.first_name} ${vo.last_name}<br>
	입사일 : ${vo.hire_date}<br>
	부서코드 : ${vo.department_id}<br>
	이메일 : ${vo.email}<br>
	전화번호 : ${vo.phone_number}<br>
	직종코드 : ${vo.job_id}<br>
	급여 : ${vo.salary}
</body>
</html>