package com.studdao;

import com.studdao.dao.*;
import com.studdao.entity.Student;
public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    StudentDao stdao = new StudentDao_Implementation();
   // Student stud1 = new Student("Priyanka", "pune", "priyanka@123.com",21);
   // stdao.saveStudent(stud1);
    
   // Student stud2 = new Student("Devisha", "Satara", "Devisha@456.com",20);
    //stdao.saveStudent(stud2);
    
   // stdao.readStudent();
    //stdao.updateStudent(2);
    stdao.deleteStudent(5);
    
    
		  
	}

}
