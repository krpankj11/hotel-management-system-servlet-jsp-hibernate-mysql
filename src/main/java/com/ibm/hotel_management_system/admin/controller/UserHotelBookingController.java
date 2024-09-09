package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;
import java.util.List;

import com.ibm.hotel_management_system.admin.dao.UserDao;
import com.ibm.hotel_management_system.dto.HotelBooking;
import com.ibm.hotel_management_system.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/userHotelBooking")
public class UserHotelBookingController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		UserDao userDao = new UserDao();
		
		String email = (String) httpSession.getAttribute("userSession");
		
		User user=userDao.loginUserByEmailAndPasswordDao(email);
		
		List<HotelBooking> bookings=userDao.getAllBookingDetailsDao(user.getId());
		
		req.setAttribute("hotelBookings", bookings);
		
		req.getRequestDispatcher("user-booking.jsp").forward(req, resp);
	}
}
