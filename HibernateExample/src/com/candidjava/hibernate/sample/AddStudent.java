package com.candidjava.hibernate.sample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	
	public static void main(String args[]) throws Exception {

		String name = "Robin_Pooppillikudiyil";
		String degree = "B-Tech";
		String phone = "9656810094";
		String email = "robin@gmail.com";

		Student s1 = new Student();
		s1.setDegree(degree);
		s1.setEmail(email);
		s1.setName(name);
		s1.setPhone(phone);

		try {
			
			
			SessionFactory sessionFactory = new Configuration().configure(
					"/hibernate.cfg.xml").buildSessionFactory();

			Session s = sessionFactory.openSession();

			Transaction tx = s.beginTransaction();

			s.save(s1);

			tx.commit();
			s.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println("Initial SessionFactory creation failed." + e);
		}
		System.out.println("Added to Database");
	}// end of method
}// end of class