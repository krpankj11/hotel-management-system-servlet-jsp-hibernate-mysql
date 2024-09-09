package com.ibm.hotel_management_system.admin.controller;

import java.io.IOException;

import com.ibm.hotel_management_system.admin.dao.AdminDao;
import com.ibm.hotel_management_system.dto.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/loginAdmin")
public class AdminLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		AdminDao dao = new AdminDao();
		
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		Admin admin=dao.fetchAdminByEmailDao(email);
		
		if(admin!=null) {
			
			if(pass.equals(admin.getPassword())) {
				httpSession.setAttribute("adminSession", email);
				req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "password is wrong");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "email is wrong");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
	}
}
