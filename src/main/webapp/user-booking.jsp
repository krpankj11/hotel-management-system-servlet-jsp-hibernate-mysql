<%@page import="com.ibm.hotel_management_system.dto.HotelBooking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			List<HotelBooking> bookings =(List<HotelBooking>)request.getAttribute("hotelBookings");
		%>
		<jsp:include page="user-navbar.jsp"></jsp:include>
		
		<%
		 for(HotelBooking booking:bookings){
		%>
		<h3>Bookings details</h3>
		<%}%>
</body>
</html>