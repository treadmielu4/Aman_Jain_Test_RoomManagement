package com.test.room.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.room.dao.RoomDao;
import com.test.room.model.Booking;
import com.test.room.model.CustomerDetail;
import com.test.room.model.Room;
import com.test.room.service.CustomerService;

public class RoomController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	RoomDao roomdao;
	
	
	@RequestMapping(value = "/createRoom/{roomId}/{roomName}/{buildingName}/{floorNo}")
	public ResponseEntity<?> createRoom(@PathVariable("roomId") int roomId,@PathVariable("roomName") String roomName ,@PathVariable("buildingName") String buildingName, @PathVariable("floorNo") int floorNo ) {
		customerService.createRoom(new Room(roomId,roomName,buildingName,floorNo));

		return new ResponseEntity<String>("Room is created Successfully",HttpStatus.OK);

	}

	

	@RequestMapping(value = "/cancelBook/{bookingId}", method = RequestMethod.POST)
	public ResponseEntity<?> cancelBook(@PathVariable("bookingId") int bookingId) {
		

		boolean checkid = customerService.validateBookId(bookingId);

		if (checkid == false) {
			return new ResponseEntity<String>("Booking ID is not valid",HttpStatus.NOT_FOUND);
		} else {
			customerService.cancelBooking(bookingId);
			return new ResponseEntity<String>("Booking Cancelled",HttpStatus.OK);
		}


	}
	@RequestMapping(value = "/showallcustomers")
	public ResponseEntity<?> showallcustomer() {

		List<CustomerDetail> customerDetail = customerService.showallcustomer();
		return new ResponseEntity<List<CustomerDetail>>(customerDetail,HttpStatus.OK);
		

	}
	
	
	@RequestMapping(value = "/showAvailableRoom/{startdatetime}/{enddatetime}/{buildingname}")
	public ResponseEntity<?> showAvailableRoom(@PathVariable("startdatetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startdatetime,
			@PathVariable("enddatetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime enddatetime,
			@PathVariable("buildingname") String buildingName) {
		long startdate = startdatetime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long enddate = enddatetime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		List<Room> freeRooms = customerService.validateTime(startdate, enddate, buildingName);
		
		if(freeRooms==null) {
			return new ResponseEntity<String>("Room is not available in given parameters",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<String>("Room is available",HttpStatus.OK);
		}

		
		

	}
	
	
	
	@RequestMapping(value = "/deleteEmployee/{empId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("empId") int empId) {
		
		boolean checkid = customerService.validateCustomerId(empId);
		if (checkid == false) {
			return new ResponseEntity<String>("Wrong Customer ID",HttpStatus.NOT_FOUND);
		} else {
			customerService.deleteCustomer(empId);
			return new ResponseEntity<String>("Customer data Deleted",HttpStatus.OK);
			
		}

	}



}

