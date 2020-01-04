package com.joydeep.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;
import com.joydeep.hibernate.model.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		//
		UserDetails uds=new UserDetails();
		uds.setUserName("Joydeep Chowdhury");
		UserDetails uds2=new UserDetails();
		uds2.setUserName("Pramit Karmakar");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("BMW");
		uds.setVehicle(vehicle);
		uds2.setVehicle(vehicle);
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(uds);
        session.save(uds2);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();
        //Lazy fetching by hibernate. It executes querry on address table once the getter is executed
       // Collection<Address> addressList= retrievedUser.getListOfAddresses();
       
       
	}

}
