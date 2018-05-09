package com.cm.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cm.curd.HibernateUtil;

public class InheritanceMain {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		// For Single Table strategy
		VehicleForSingleTable vehicleForSingleTable = new VehicleForSingleTable();
		vehicleForSingleTable.setVehicleName("car");
		
		TwoWheelerSingleTable twoWheelerSingleTable = new TwoWheelerSingleTable();
		twoWheelerSingleTable.setVehicleName("Splender");
		twoWheelerSingleTable.setSteeringTwoWheeler("Handel");
		
		FourWheelerSingleTable fourWheelerSingleTable = new FourWheelerSingleTable();
		fourWheelerSingleTable.setVehicleName("Aulto");
		fourWheelerSingleTable.setSteeringFourheeler("Wheel");
		
		session.save(vehicleForSingleTable);
		session.save(twoWheelerSingleTable);
		session.save(fourWheelerSingleTable);
		
		
		//For Per class strategy
		VehicleForPerClass vehicleForPerClass = new VehicleForPerClass();
		vehicleForPerClass.setVehicleName("Car");
		
		TwoWheelerPerClass twoWheelerPerClass = new TwoWheelerPerClass();
		twoWheelerPerClass.setVehicleName("Splender");
		twoWheelerPerClass.setSteeringTwoWheeler("Handel");
		
		FourWheelerPerClass fourWheelerPerClass = new FourWheelerPerClass();
		fourWheelerPerClass.setVehicleName("Aulto");
		fourWheelerPerClass.setSteeringFourheeler("Wheel");
		
		session.save(vehicleForPerClass);
		session.save(twoWheelerPerClass);
		session.save(fourWheelerPerClass);
		
		
		//For Joined Strategy
		VehicleForJoined vehicleForJoined = new VehicleForJoined();
		vehicleForJoined.setVehicleName("Car");
		
		TwoWheelerJoined twoWheelerJoined = new TwoWheelerJoined();
		twoWheelerJoined.setVehicleName("Splender");
		twoWheelerJoined.setSteeringTwoWheeler("Handel");
		
		FourWheelerJoined fourWheelerJoined = new FourWheelerJoined();
		fourWheelerJoined.setVehicleName("Aulto");
		fourWheelerJoined.setSteeringFourWheeler("Wheel");
		
		session.save(vehicleForJoined);
		session.save(twoWheelerJoined);
		session.save(fourWheelerJoined);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
