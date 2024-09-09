package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value = "/logoutOwner")
public class HotelOwnerLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("hownerSession")!=null) {
			
			httpSession.invalidate();
			
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}
	}
}
