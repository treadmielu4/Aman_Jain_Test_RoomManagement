package com.test.room.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")

@NamedQueries({
		@NamedQuery(name = "Booking.startendbetween", query = "select b.roomId from Booking b where b.fromDate>=?1 and b.toDate <=?2"),
		@NamedQuery(name = "Booking.findBooking", query = "select b from Booking b where b.empId = ?1 ")

})

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookingId;
	private int empId;
	private long fromDate;
	private long toDate;
	private int roomId;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public long getFromDate() {
		return fromDate;
	}

	public void setFromDate(long fromDate) {
		this.fromDate = fromDate;
	}

	public long getToDate() {
		return toDate;
	}

	public void setToDate(long toDate) {
		this.toDate = toDate;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", empId=" + empId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", roomId=" + roomId + "]";
	}

}
