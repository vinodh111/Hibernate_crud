package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Customer;
import com.greatlearning.entity.Order;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class CreateCustomerOrder {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Customer.class)
				                     .addAnnotatedClass(Order.class) 
				                     .buildSessionFactory();
		
		//create session
		Session session = factory.openSession();
		Customer ravi = null;
		try {
			//transient object
			 ravi = new Customer("Sarath", "Bangalore");
			 
			//child
			Order smartphone = new Order("i-Phone", 50000);
			Order iMac = new Order("i-Mac", 250000);
			
			
			//start a transaction
			session.beginTransaction();

			ravi.placeOrder(smartphone);
			ravi.placeOrder(iMac);
			
			session.save(ravi);
			//commit transaction
			session.delete(ravi);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
