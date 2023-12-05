package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Author;
import com.greatlearning.entity.Book;
import com.greatlearning.entity.Course;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class AuthorClient {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Author.class)
									.addAnnotatedClass(Book.class)
									.buildSessionFactory();

		// create session
		Session session = factory.openSession();

		try {
			Author ramesh = new Author();
			ramesh.setName("Ramesh");
			
			Author suresh = new Author();
			suresh.setName("Suresh");
			
			Book book1 = new Book();
			book1.setName("Introduction to Statistics");
			
			Book book2 = new Book();
			book2.setName("Introduction to Programming");

			
			Book book3 = new Book();
			book3.setName("Physicology of Money");
			
			Book book4 = new Book();
			book4.setName("Atomic Habbits");

			
			ramesh.addBook(book1);
			ramesh.addBook(book2);
			
			suresh.addBook(book3);
			suresh.addBook(book4);
			
			ramesh.addBook(book4);
			ramesh.addBook(book3);
			
			
			session.beginTransaction();
			session.save(book1);
			session.save(book2);
			session.save(book3);
			session.save(book4);
			session.save(ramesh);
			session.save(suresh);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
