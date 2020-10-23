package com.test.room.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.room.dao.CustomerDetailDao;
import com.test.room.dao.RoomBookingDao;
import com.test.room.dao.RoomDao;
import com.test.room.model.Booking;
import com.test.room.model.CustomerDetail;
import com.test.room.model.Room;


@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	RoomDao roomdao;

	@Autowired
	CustomerDetailDao customerdetaildao;

	@Autowired
	RoomBookingDao bookingdao;
	@Autowired
	EntityManager em;

	

	@Override
	public void createRoom(Room room) {
		// TODO Auto-generated method stub

		roomdao.save(room);

	}

	

	@Override
	public void deleteCustomer(int empId) {
		// TODO Auto-generated method stub

		customerdetaildao.deleteById(empId);

	}

	@Override
	public List<CustomerDetail> showallcustomer() {
		// TODO Auto-generated method stub

		List<CustomerDetail> showcustomerlist = (List<CustomerDetail>) customerdetaildao.findAll();
		return showcustomerlist;

	}

	
	@Override
	public boolean validateCustomerId(int custId) {
		// TODO Auto-generated method stub
		return customerdetaildao.existsById(custId);

	}

	@Override
	public List<Room> validateTime(long startdate, long enddate, String buildingname) {
		// TODO Auto-generated method stub

		Query q = em.createNamedQuery("Room.getfreeroom");
		q.setParameter(1, startdate);
		q.setParameter(2, enddate);
		q.setParameter(3, buildingname);
		List<Room> ro = q.getResultList();
		System.out.println(ro);
		return ro;

	}

	@Override
	public List<String> getbuildingname() {

		Query q = em.createNamedQuery("Room.getbuildingname");
		List<String> a = q.getResultList();

		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public List<Booking> viewBooking(int empId) {
		// TODO Auto-generated method stub

		
	
		List<Booking> showbook=bookingdao.findByEmpId(empId);
		
		return showbook;

	}

	@Override
	public void cancelBooking(int bookId) {
		// TODO Auto-generated method stub
		
		
		bookingdao.deleteById(bookId);
		
	}

	@Override
	public boolean validateBookId(int bookId) {
		// TODO Auto-generated method stub
		
		
		
		return bookingdao.existsById(bookId);
	}

	

	@Override
	public List<Booking> bookroom(Booking book) {
		// TODO Auto-generated method stub
		return (List<Booking>) bookingdao.save(book);
	}

	
}
