package com.greatlearning.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;

public class DeleteTeacher {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.buildSessionFactory();

		// create session
		Session session = factory.openSession();

		try {

			int teacherId = 1;

			// start a transaction
			session.beginTransaction();

			System.out.println("getting teacher with id :" + teacherId);

			// fetching record where teacher id = 1
			Teacher tempTeacher = session.get(Teacher.class, teacherId);

			// deleting value using session.delete method
			System.out.println("delete teacher--");
			session.delete(tempTeacher);

			// commit transaction
			session.getTransaction().commit();

			
			session.beginTransaction();

			// delete teacher with id = 2 using createQuery
			System.out.println("delete teacher with id = 2");
			session.createQuery("delete from Teacher where id = 2 ").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
