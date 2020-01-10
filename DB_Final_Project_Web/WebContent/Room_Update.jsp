<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="client.RoomDTO" %>
<%@ page import="client.RoomDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	String roomno = request.getParameter("roomno");
	String type = request.getParameter("type");
	String usee = request.getParameter("usee");
	String tow = request.getParameter("tow");
	String bed = request.getParameter("bed");
	String amenity = request.getParameter("amenity");
	
	RoomDTO data = new RoomDTO();

	data.setNo(no);
	data.setRoomno(roomno);
	data.setType(type);
	data.setUsee(usee);
	data.setTow(tow);
	data.setBed(bed);
	data.setAmenity(amenity);
	
	RoomDAO manager = RoomDAO.getInstance();
	manager.update(data);
%>
<script>
	alert("객실 수정 완료");
	location.href="room_manage.jsp";
</script>