package com.cm.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FourWheelerJoined extends VehicleForJoined{

	@Column(name="steering_type")
	private String steeringFourWheeler;
	@Column(name="vehicle_name")
	private String vehicleName;
	public String getSteeringFourWheeler() {
		return steeringFourWheeler;
	}
	public void setSteeringFourWheeler(String steeringFourWheeler) {
		this.steeringFourWheeler = steeringFourWheeler;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
}
