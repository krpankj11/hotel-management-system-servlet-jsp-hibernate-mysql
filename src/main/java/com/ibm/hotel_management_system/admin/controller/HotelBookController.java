package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;
import java.util.Random;
import java.util.RandomAccess;

import com.ibm.hotel_management_system.admin.dao.HotelDao;
import com.ibm.hotel_management_system.admin.dao.UserDao;
import com.ibm.hotel_management_system.dto.Hotel;
import com.ibm.hotel_management_system.dto.HotelBooking;
import com.ibm.hotel_management_system.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/hotelBooking")
public class HotelBookController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		UserDao dao = new UserDao();
		
		HotelDao hotelDao = new HotelDao();
		
		int hotelId = Integer.parseInt(req.getParameter("hotelId"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		long adhar = Long.parseLong(req.getParameter("adhar"));
		
		String userEmail = (String) httpSession.getAttribute("userSession");
		
		if(userEmail!=null) {
			
			User user = dao.loginUserByEmailAndPasswordDao(userEmail);
			
			Hotel hotel = hotelDao.fetchHotelByIdDao(hotelId);
			
			String number="jsp"+(long) Math. floor(Math. random() * 9_000_000_000L) + 1_000_000_000L;
		
			HotelBooking booking = new HotelBooking(number, name, phone, adhar, user, hotel);
			
			dao.saveHotelBookingDao(booking);
			
			req.setAttribute("msg", "booked success");
			
		    req.getRequestDispatcher("hotel-booking.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("msg", "your are not loggedin please login");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}
