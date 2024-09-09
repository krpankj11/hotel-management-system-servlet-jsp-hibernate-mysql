<%@page import="com.ibm.hotel_management_system.admin.dao.HotelDao"%>
<%@page import="java.util.List"%>
<%@page import="com.ibm.hotel_management_system.dto.Hotel"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel-Management-System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
	rel="stylesheet" />
<style type="text/css">
button:hover {
	background-color: #f39c12; /* change to your desired color */
	color: white; /* change to your desired color */
}

/* * {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
 */
main {
	padding: 200px;
	display: grid;
	height: 100vh;
	width: 100vw;
	align-item: center;
	justify-content: center;
}

footer {
	display: grid;
	width: 100%;
	padding: 50px;
	height: 5px;
	align-item: center;
	justify-content: center;
	background-color: grey;
	font-size: 16px;
}
</style>
</head>
<body>
	<jsp:include page="index-nav.jsp"></jsp:include>
	<%
	List<Hotel> hotels = new HotelDao().getAllVerifiedHotelDetailsDao();
	%>
	<%
	for (Hotel hotel : hotels) {
	%>

	<%
	byte b[] = hotel.getImage();

	String image = Base64.getEncoder().encodeToString(b);
	%>
	<section style="margin-top: 40px;">
		<article>
			<div class="card"
				style="width: 17rem; height: 27rem; float: left; margin-left: 10px;">
				<div>
					<h4>
						HotelName =
						<%=hotel.getName()%></h4>
					<img src="data:image/png;base64,<%=image%>" class="card-img-top"
						alt="myImage" width="60px;" height="200px;">
				</div>

				<div class="card-body" style="float: left;">
					<h6 class="card-text">
						final price=<%=(int) hotel.getPrice()%>
					</h6>
					<h6 class="card-text">
						Address=<%=hotel.getAddress()%>
					</h6>
					<h6 class="card-text">
						City=<%=hotel.getCity()%>
					</h6>
					<div style="display: flex; margin-top: 50px;">

						<a href="user-login.jsp"><button
								type="button" class="btn btn-primary" style="width: 200px;">BookNow</button></a>

					</div>
				</div>
			</div>
		</article>
	</section>
	<%
	}
	%>
	<footer>
		<span>Copyright 2024 JSP</span>
	</footer>
</body>
</html>