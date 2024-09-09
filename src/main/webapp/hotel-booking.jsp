<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hotel-owner-registration</title>
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
.gradient-custom-3 {
	/* fallback for old browsers */
	background: #84fab0;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5),
		rgba(143, 211, 244, 0.5));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(132, 250, 176, 0.5),
		rgba(143, 211, 244, 0.5))
}

.gradient-custom-4 {
	/* fallback for old browsers */
	background: #84fab0;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1),
		rgba(143, 211, 244, 1));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(132, 250, 176, 1),
		rgba(143, 211, 244, 1))
}
</style>
</head>
<body>

	<%
		String msg = (String)request.getAttribute("msg");
	
		int id = Integer.parseInt(request.getParameter("hotelId"));
	%>

	<jsp:include page="user-navbar.jsp"></jsp:include>
	
	<section class="vh-100 bg-image"
		style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">BookNow</h2>

								<%if(msg!=null) {%> <h3><%=msg%></h3><%}%>
								<form action="hotelBooking" method="post">
									
									<input type="text" name="hotelId" value="<%=id%>" hidden="true">
									
									<div data-mdb-input-init class="form-outline mb-4">
										<input type="text" id="form3Example1cg"
											class="form-control form-control-lg" name="name"/> <label
											class="form-label" for="form3Example1cg">Customer Name</label>
									</div>

									<div data-mdb-input-init class="form-outline mb-4">
										<input type="text" id="form3Example3cg"
											class="form-control form-control-lg" name="phone" /> <label
											class="form-label" for="form3Example3cg">Customer Phone</label>
									</div>

									<div data-mdb-input-init class="form-outline mb-4">
										<input type="text" id="form3Example4cg"
											class="form-control form-control-lg" name="adhar"/> <label
											class="form-label" for="form3Example4cg">Adhar Number</label>
									</div>

									<div class="d-flex justify-content-center">
										<button type="submit" data-mdb-button-init
											data-mdb-ripple-init
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">BookNow</button>
									</div>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>