package com.springORM.Doa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springORM.Entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	// get the single data(object)
		public Student getStudent(int studentId) {
			Student student = this.hibernateTemplate.get(Student.class, studentId);
			return student;
		}

		// get all students(all rows)
		public List<Student> getAllStudents() {
			List<Student> students = this.hibernateTemplate.loadAll(Student.class);
			return students;
		}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	// deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	// updating data...
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

	

}
