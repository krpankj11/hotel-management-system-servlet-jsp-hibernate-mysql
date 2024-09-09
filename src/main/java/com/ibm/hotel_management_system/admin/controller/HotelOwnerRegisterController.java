package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;

import com.ibm.hotel_management_system.admin.dao.HotelOwnerDao;
import com.ibm.hotel_management_system.dto.HotelOwner;

import jakarta.persistence.Column;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/hotelOwnerRegister")
public class HotelOwnerRegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		HotelOwner owner = new HotelOwner(name, email, password, phone);

		HotelOwner owner2 = new HotelOwnerDao().saveHotelOwnerDao(owner);

		if (owner2 != null) {
			req.setAttribute("msg", "Registered SuccessFully!!!");
			req.getRequestDispatcher("register-hotel-owner.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Not Registered!!!");
			req.getRequestDispatcher("register-hotel-owner.jsp").forward(req, resp);
		}
	}
}
