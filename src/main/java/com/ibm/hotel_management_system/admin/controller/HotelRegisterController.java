package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import com.ibm.hotel_management_system.admin.dao.HotelDao;
import com.ibm.hotel_management_system.admin.dao.HotelOwnerDao;
import com.ibm.hotel_management_system.dto.Hotel;
import com.ibm.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(value = "/hotelRegister")
@MultipartConfig(fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5,maxRequestSize=1024*1024*5*5)
public class HotelRegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		String name = req.getParameter("name");
		String city = req.getParameter("city");
		String address = req.getParameter("address");
		double price = Double.parseDouble(req.getParameter("price"));

		Part part = req.getPart("image");
		
		InputStream inputStream = part.getInputStream();

		String email = (String) httpSession.getAttribute("hownerSession");

		if (email != null) {

			HotelOwner hotelOwner = new HotelOwnerDao().fetchHotelOwnerByEmailDao(email);

			Hotel hotel = new Hotel(name, city, address, price, inputStream.readAllBytes(), hotelOwner);

			Hotel hotel2 = new HotelDao().saveHotelDao(hotel);

			if (hotel2 != null) {
				req.setAttribute("msg", "hotel registered successfully!!!!!");

				req.getRequestDispatcher("hotel-register.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "hotel not registered!!!!!");

				req.getRequestDispatcher("hotel-register.jsp").forward(req, resp);
			}
		} else {

			req.setAttribute("msg", "please login with hotel owner and then register");

			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}
	}
}
