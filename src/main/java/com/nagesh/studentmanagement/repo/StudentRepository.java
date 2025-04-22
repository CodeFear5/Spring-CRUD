package com.nagesh.studentmanagement.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagesh.studentmanagement.model.Student;

 @Repository
 public interface StudentRepository extends JpaRepository<Student, Integer> {
 }
