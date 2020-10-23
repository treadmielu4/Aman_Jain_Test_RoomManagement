
package com.test.room.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.room.model.Booking;
import com.test.room.model.CustomerDetail;



public interface CustomerDetailDao extends CrudRepository<CustomerDetail, Integer>{
	
	List<Booking> findByEmpId(int custId);

}
