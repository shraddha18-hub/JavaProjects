package com.studdao.dao;

import com.studdao.entity.Student;

public interface StudentDao
{
   public void saveStudent(Student student);
   public void readStudent();
   public void updateStudent(int id);
   public void deleteStudent(int id);
   
	
}
