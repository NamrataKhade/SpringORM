package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;


public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("Project Started .....");

		/*// spring jdbc=>JdbcTemplate

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		
		//insert query
		
		//String query="insert into student(id,name,city) values(3,'Komal','Mumbai')";
		String query="insert into student(id,name,city) values(?,?,?)";
		
		//Fire the query
		
		int result = template.update(query,7,"Rahul","Pune");
		System.out.println("Number of record inserted..." +result);*/
		
		
		
		
		
	/*	//  INSERT Using StudentDao class
		ApplicationContext conn = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = conn.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		student.setId(12);
		student.setName("Tejaswi");
		student.setCity("pune");

		int result = studentDao.insert(student);
		System.out.println("Student  Added ........." + result);
		//System.out.println(result);*/
		
	/*	//UPDATE Using StudentDao
		ApplicationContext conn = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = conn.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		student.setId(3);
		student.setName("Anil");
		student.setCity("Delhi");
		
		int result = studentDao.change(student);
		System.out.println("Student Updated ...."+result);*/
		
		
	/*	//DELETE using StudentDao
		ApplicationContext conn = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = conn.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		int result = studentDao.delete(5);
		System.out.println("Deleted ...."+result);*/
		
		
  /*	//FETCH single data
		ApplicationContext conn = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = conn.getBean("studentDao", StudentDao.class);
		Student student = studentDao.getStudent(12);
		//System.out.println(student);
		//System.out.println("getStudent"+student);
		
		System.out.println("Student data :"+student);*/
	
	/*	//FETCH ALL Records
		ApplicationContext conn = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = conn.getBean("studentDao", StudentDao.class);
		List<Student> students = studentDao.getAllStudents();
		for(Student s:students) 
		{
			System.out.println(" "+s);
		}
		*/
		
		
		// Without using XML ....Using ANOTATION
		ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		List<Student> students = studentDao.getAllStudents();
		for(Student s:students) 
		{
			System.out.println(s);
		}
		
	}
}
