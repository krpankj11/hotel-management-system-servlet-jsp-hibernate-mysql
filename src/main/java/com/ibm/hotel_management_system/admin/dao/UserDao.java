package com.ibm.hotel_management_system.admin.dao;

import java.util.Base64;
import java.util.List;

import com.ibm.hotel_management_system.dto.HotelBooking;
import com.ibm.hotel_management_system.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserDao {

	EntityManager em = Persistence.createEntityManagerFactory("hotel-project").createEntityManager();

	EntityTransaction et = em.getTransaction();

	public User saveUserDao(User user) {

		try {
			et.begin();
			em.persist(user);
			et.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User loginUserByEmailAndPasswordDao(String email) {
		Query query=em.createNativeQuery("select * from user where email=?1",User.class);
		query.setParameter(1, email);
		try {
			return (User)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public HotelBooking saveHotelBookingDao(HotelBooking booking) {
		try {
			et.begin();
			em.persist(booking);
			et.commit();
			return booking;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<HotelBooking> getAllBookingDetailsDao(int userId){
	   List<HotelBooking> bookings = em.createQuery("from HotelBooking").getResultList();
	   return bookings.stream().filter(a->a.getUser().getId()==userId).toList();
	}
}
