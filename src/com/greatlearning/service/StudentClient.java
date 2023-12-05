package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Student;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class StudentClient {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Course.class)
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
		
		//create session
		Session session = factory.openSession();
		
		try {

			Student ramesh = new Student("Ramesh", "ramesh@gmail.com");
			
			Student suresh = new Student("Suresh", "suresh@gmail.com");
			
			Course statastics = new Course("Stats", 40);
			Course science = new Course("Science", 40);
			Course computers = new Course("Computers", 60);
			Course history = new Course("History", 20);
			
			ramesh.addCourse(statastics);
			ramesh.addCourse(science);
			ramesh.addCourse(computers);
			ramesh.addCourse(history);
			
			
			suresh.addCourse(science);
			suresh.addCourse(computers);
			
			
			
			
			//start a transaction
			session.beginTransaction();
			
			session.save(statastics);
			session.save(science);
			session.save(computers);
			session.save(history);
			
			
			
			//save the student object
			System.out.println("saving the teacher ...");
			
			session.save(ramesh);
			
			session.save(suresh);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}

