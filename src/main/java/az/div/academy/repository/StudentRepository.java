package az.div.academy.repository;

import az.div.academy.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  @Query(value = "select s from Student s where s.age>:age")
  List<Student> findAllStudents(Integer age);


//@Query("select s from Student s where s.age>:age") wrote this. but not work my computer.
//  void updateStudents(StudentDto studentDto);
}
