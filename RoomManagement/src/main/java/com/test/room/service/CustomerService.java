package com.test.room.service;
import java.util.List;
import java.util.Optional;

import com.test.room.model.Booking;
import com.test.room.model.CustomerDetail;

import com.test.room.model.Room;


public interface CustomerService {
	
	public boolean validateAdmin(int empId, String password);
	
	public void createRoom(Room room);
	
	public void addEmployee(CustomerDetail employeedetail);
	public void deleteEmployee(CustomerDetail employeedetail);
	public List<CustomerDetail>  showallemployee();
	
	public void time(long start , long end);

	public boolean validateEmployeeId(int empId);

	public List<Room> validateTime(long startdate, long enddate, String buildingname);

	public List<String> getbuildingname();

	public List<Booking> viewBooking(int bookId);

	public void cancelBooking(int bookId);

	public boolean validateBookId(int bookId);

	public boolean validateEmployeeIdInBooking(int empId);

	public void bookroom(Booking book);

	

	
	
}
