package com.cm.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FourWheelerPerClass extends VehicleForPerClass{

	@Column(name="steering_type")
	private String steeringFourheeler;
	@Column(name="vehicle_name")
	private String vehicleName;
	public String getSteeringFourheeler() {
		return steeringFourheeler;
	}
	public void setSteeringFourheeler(String steeringFourheeler) {
		this.steeringFourheeler = steeringFourheeler;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
