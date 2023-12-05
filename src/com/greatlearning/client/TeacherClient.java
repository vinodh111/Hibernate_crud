package com.greatlearning.client;

import com.greatlearning.entity.Teacher;

public class TeacherClient {
	
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Ramesh");
		teacher.setLastName("Kumar");
		
		System.out.println(teacher);
		System.out.println(12);
		System.out.println("hari");
		System.out.println(false);
	}

}
