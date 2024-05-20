package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entities.Student;
import com.spring.orm.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Project Started .......");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("StudentDao", StudentDao.class);

		/*
		 * Student student=new Student(2224,"Tejaswi","A.Nagar"); int r=
		 * studentDao.insert(student); System.out.println("Inserted Sussfully : "+r);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go=true;
		while (go) {
			System.out.println("PRESS 1 for ADD new student");
			System.out.println("PRESS 2 for Diaplay All Student");
			System.out.println("PRESS 3 for get detatils of single student");
			System.out.println("PRESS 4 for DELETE students");
			System.out.println("PRESS 5 for UPDATE student");
			System.out.println("PRESS 6 for EXIT");

			try {
				int choice = Integer.parseInt(br.readLine());
			/*	if(choice==1) {
					//Add new  student
				}*/
				
			switch(choice) {
			case 1:
				//add New student
			/*	Student student=new Student(2225,"Anuradha.K","A.Nagar");
				int r= studentDao.insert(student); System.out.println("Inserted Sussfully : "+r);*/
				
				System.out.println("Enter Student Id :");
				int sid=Integer.parseInt(br.readLine());
				System.out.println("Enter Student Name :");
				String name=br.readLine();
				System.out.println("Enter Student City :");
				String city=br.readLine();
				Student s=new Student();
				s.setStudentId(sid);
				s.setStudentName(name);
				s.setStudentCity(city);
				
				int result = studentDao.insert(s);
				System.out.println("New Record added :"+result);
				System.out.println("--------------------------------------------");
				 
				break;
			case 2:
				//Display ALL student
				
				List<Student> students1 = studentDao.getAllStudents();
				for(Student s11:students1) 
				{
					System.out.println(" "+s11);
				}
				break;
				
			case 3:
				//Display single student
				/*Student student2 = studentDao.getStudent(2222);
				System.out.println("Student data :"+student2);*/
				System.out.println("Enter Student Id");
				int sid1=Integer.parseInt(br.readLine());
				Student s11 = studentDao.getStudent(sid1);
				System.out.println("-------------Student Deltail---------");
				System.out.println("Id::"+s11.getStudentId()+" "+"Name::"+s11.getStudentName()+" "+"City::"+s11.getStudentCity());
				System.out.println("-------------------------------------------------------");
				break;
			case 4:
				//Delete Student
				System.out.println("Enter user id");
				int idStu=Integer.parseInt(br.readLine());
				studentDao.deleteStudent(idStu);
				System.out.println("Student deleted");
				// studentDao.deleteStudent(2223);
				 
				System.out.println("Record Deleted ....");
				break;
			case 5:
				//UPDATE Student
				System.out.println("Enter user id");
				int updateStu=Integer.parseInt(br.readLine());
				System.out.println("Enter user name");
				String name1=br.readLine();

				System.out.println("Enter user city");
				String city1=br.readLine();
				Student student1 =new Student();
				student1.setStudentId(updateStu);
				student1.setStudentName(name1);
				student1.setStudentCity(city1);
				studentDao.updateStudent(student1);
				System.out.println("Record Updated Sucessfully ......!!!");
				break;
			case 6:
				//Exit
				go=false;
				break;
				
			
			}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid Input Try with another one !!");
			}
		}
		System.out.println("Thank you!!");

	}
}
