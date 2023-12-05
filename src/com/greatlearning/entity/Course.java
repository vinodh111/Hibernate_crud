package com.greatlearning.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "duration")
	private int durationInMonths;

	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "students_courses", joinColumns = @JoinColumn(name =
	 * "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id") ) private
	 * Set<Student> students = new HashSet<>();
	 */
	public Course(String name, int durationInMonths) {
		super();
		this.name = name;
		this.durationInMonths = durationInMonths;
	}
	
	private Course() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	
	  public Teacher getTeacher() { return teacher; }
	  
	  public void setTeacher(Teacher teacher) { this.teacher = teacher; }
	 

	/*
	 * public Set<Student> getStudents() { return students; }
	 * 
	 * public void setStudents(Set<Student> students) { this.students = students; }
	 */
	@Override
	public int hashCode() {
		return Objects.hash(durationInMonths, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return durationInMonths == other.durationInMonths && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", durationInMonths=" + durationInMonths + "]";
	}

}
