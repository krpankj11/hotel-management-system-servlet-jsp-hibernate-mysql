package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;

import com.ibm.hotel_management_system.admin.dao.HotelOwnerDao;
import com.ibm.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/hotelOwnerLogin")
public class HotelOwnerLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession httpSession = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HotelOwner owner2 = new HotelOwnerDao().fetchHotelOwnerByEmailDao(email);

		if (owner2 != null) {
			
			if(owner2.getVerify().equalsIgnoreCase("yes")) {
				
				if(password.equals(owner2.getPassword())) {
					httpSession.setAttribute("hownerSession", email);
					req.getRequestDispatcher("home-hotel-owner.jsp").forward(req, resp);
				}else {
					req.setAttribute("msg", "wrong password");
					req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
				}
				
			}else {
				req.setAttribute("msg", "you are not verified contact with admin");
				req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "email is incorrect");
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}
	}
}
