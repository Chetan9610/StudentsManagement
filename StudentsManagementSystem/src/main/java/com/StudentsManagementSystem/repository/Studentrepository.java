package com.StudentsManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.StudentsManagementSystem.Student;
@Repository
public interface Studentrepository extends JpaRepository<Student,Integer> {

}

	