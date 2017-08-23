package com.hibernate.startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
	

		Address addr1 = new Address();
		addr1.setCity("NewYork");
		addr1.setState("NY");
		addr1.setStreet("Lexington Ave");
		addr1.setZipCode("10023");

		Address addr2 = new Address();
		addr2.setCity("NewYork");
		addr2.setState("NY");
		addr2.setStreet("Madison Ave");
		addr2.setZipCode("91111");
		
		OfficeAddress officeAddress = new OfficeAddress();
		officeAddress.setAddressType("OFFICE");
		
		HomeAddress homeAddress = new HomeAddress();
		homeAddress.setAddressType("HOME");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(addr1);
		session.save(addr2);
		session.save(officeAddress);
		session.save(homeAddress);
		// session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
}
