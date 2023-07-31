package az.div.academy.repository;

import az.div.academy.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDetailRepository extends JpaRepository<Student, Integer>{
    @Query("select s from Student s")
    List<Student> findAllStudentDetail();
}
