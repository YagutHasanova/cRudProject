package az.div.academy.controller;

import az.div.academy.model.entity.Student;
import az.div.academy.model.entity.StudentDetail;
import az.div.academy.model.dto.StudentDto;
import az.div.academy.model.dto.StudentResponseDto;
import az.div.academy.model.mapper.StudentMapper;
import az.div.academy.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudent(@RequestParam Integer age) {
        return studentService.getAllStudent(age);
    }

//    @PutMapping
//    public void updateStudent (@PathVariable Integer id, @RequestBody StudentDto studentDto){
//        studentService.updateStudent(studentDto);
//    }

    @DeleteMapping
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }


    @PostMapping("/detail")
    public StudentDetail createStudentDetail(@RequestBody StudentDetail student) {
        return studentService.createStudentDetail(student);
    }

    @GetMapping("/detail")
    public List<Student> getAllStudentDetails() {
        return studentService.getAllStudentDetails();
    }

    @PutMapping("{id}")
    public StudentResponseDto updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return studentMapper.toStudentResponse(studentService.updateStudent(id, studentDto));
    }

}
