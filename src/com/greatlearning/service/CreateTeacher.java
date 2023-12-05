package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class CreateTeacher {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Teacher.class)
				                     .addAnnotatedClass(TeacherDetails.class)
				                     .addAnnotatedClass(Course.class)
				                     .buildSessionFactory();
		
		//create session
		Session session = factory.openSession();
		Teacher teacher1 = null;
		
		Course maths = new Course("Maths", 12);
		Course science = new Course("Science", 10);
		Course english = new Course("English", 10);
		Course hindi = new Course("Hindi", 10);
		
		try {
			System.out.println("Creating new teacher object...");
			 teacher1 = new Teacher("Sarath", "Binny", "sarath@gl.com");
			 
			 TeacherDetails teacherDetails = new TeacherDetails();
			 teacherDetails.setCity("Bangalore");
			 teacherDetails.setState("Karnataka");

			 session.beginTransaction();
				//save the student object
				System.out.println("saving the teacher ...");
				
				
				//set the relationship between the teacher and the teacher details
				/*
				 * teacher1.setTeacherDetails(teacherDetails);
				 * teacherDetails.setTeacher(teacher1);
				 */
				
				teacher1.addTeacherDetails(teacherDetails);
				teacher1.addCourse(maths);
				teacher1.addCourse(science);
				teacher1.addCourse(english);
				
				session.save(teacher1);
				teacher1.setLastName("Mehta");
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			teacher1.addCourse(hindi);
			session.beginTransaction();
			session.saveOrUpdate(teacher1);
			session.getTransaction().commit();
			
			teacher1.getCourses().forEach(c -> System.out.println(c.getName()));
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
