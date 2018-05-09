package com.cm.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TwoWheelerJoined extends VehicleForJoined{

	@Column(name="steering_type")
	private String steeringTwoWheeler;
	@Column(name="vehicle_name")
	private String vehicleName;
	public String getSteeringTwoWheeler() {
		return steeringTwoWheeler;
	}
	public void setSteeringTwoWheeler(String steeringTwoWheeler) {
		this.steeringTwoWheeler = steeringTwoWheeler;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
