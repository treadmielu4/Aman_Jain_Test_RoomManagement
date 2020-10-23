package com.test.room.service;
import java.util.List;
import java.util.Optional;

import com.test.room.model.Booking;
import com.test.room.model.CustomerDetail;

import com.test.room.model.Room;


public interface CustomerService {
	
	
	
	
	public void deleteCustomer(int empId);


	public boolean validateCustomerId(int empId);

	public List<Room> validateTime(long startdate, long enddate, String buildingname);

	public List<String> getbuildingname();

	public List<Booking> viewBooking(int bookId);

	public void cancelBooking(int bookId);

	public boolean validateBookId(int bookId);

	

	public List<Booking> bookroom(Booking book);
	public void createRoom(Room room);
	public List<CustomerDetail> showallcustomer();

	

	
	
}
