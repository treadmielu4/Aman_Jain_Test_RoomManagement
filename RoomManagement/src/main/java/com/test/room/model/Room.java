package com.test.room.model;

import javax.persistence.*;

@Entity
@Table(name="Room")



@NamedQueries(
		{
			@NamedQuery(name="Room.getbuildingname" ,query= "select distinct r.buildingName from Room r"),
			@NamedQuery(name="Room.getfreeroom",query="select r from Room r where r.buildingName = ?3 and r.roomId NOT IN (select b.roomId from Booking b where  b.fromDate>=?1 and b.toDate <=?2) ")
		}
		)

public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private int roomId;
	
	private String roomName;
	
	private String buildingName;
	
	private int floorNo;
	
	public Room(int roomId, String roomName, String buildingName, int floorNo) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.buildingName = buildingName;
		this.floorNo = floorNo;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", buildingName=" + buildingName + ", floorNo="
				+ floorNo + "]";
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	

	
}
