package com.test.room.dao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.test.room.model.Booking;




public interface RoomBookingDao extends CrudRepository<Booking, Integer>{
	
	List<Booking> findByEmpId(int custId);

}
