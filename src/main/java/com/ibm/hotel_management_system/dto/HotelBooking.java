package com.ibm.hotel_management_system.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelBooking {

	@Id
	@Column(name = "bookingid")
	private String bookingId;
	
	@Column(name = "customername")
	private String customerName;
	
	@Column(name = "customerphone")
	private long customerPhone;
	
	@Column(name = "adharnumber")
	private long AdharNumber;
	
	@Column(name = "bookingdatetime")
	@CreationTimestamp
	private LocalDateTime bookingDateTime;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "hotelid")
	private Hotel hotel;

	public HotelBooking(String bookingId, String customerName, long customerPhone, long adharNumber, User user,
			Hotel hotel) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		AdharNumber = adharNumber;
		this.user = user;
		this.hotel = hotel;
	}
	
	
}
