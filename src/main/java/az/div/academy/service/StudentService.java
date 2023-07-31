package az.div.academy.service;

import az.div.academy.model.entity.Student;
import az.div.academy.model.entity.StudentDetail;
import az.div.academy.model.mapper.StudentMapper;
import az.div.academy.model.dto.StudentDto;
import az.div.academy.model.dto.StudentResponseDto;
import az.div.academy.repository.StudentDetailRepository;
import az.div.academy.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
//@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentDetailRepository studentDetailRepository;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, StudentDetailRepository studentDetailRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.studentDetailRepository = studentDetailRepository;
    }

    public StudentResponseDto createStudent(StudentDto studentDto) {
//        Student student = getStudent(studentDto);
        Student student = Optional.of(studentDto)
                .map(StudentService::getStudent)
                .orElseThrow(RuntimeException::new);


//        Student student = new Student();
//        student.setName(studentDto.getName());
//        student.setSurname(studentDto.getSurname());
//        student.setAge(studentDto.getAge())  //qisaldiriq bunu da metoda cixardib

        return Optional.ofNullable(studentRepository.save(student))
                .map(StudentService::getStudentResponseDto)
                .orElse(null);
    }

    private static Student getStudent(StudentDto studentDto) {
//        Student student = new Student();builder etdiyimise gore bu qziardi gelib burda deyishirik
        return Student.builder()
                .name(studentDto.getName())
                .surname(studentDto.getSurname())
                .age(studentDto.getAge())
                .createdAt(LocalDateTime.now())
                .build();
//        student.setName(studentDto.getName());
//        student.setSurname(studentDto.getSurname());
//        student.setAge(studentDto.getAge()); bunlarin evezinde yuxaridakilari yazdiq
//        return student;
    }

    //        StudentResponseDto studentResponseDto = getStudentResponseDto(student);
//        return studentResponseDto;
//    }
//metoda cixardiq  (extract metod edirik)
    private static StudentResponseDto getStudentResponseDto(Student student) {

        return StudentResponseDto.builder()
                .name(student.getName())
                .surname(student.getSurname())
                .age(student.getAge())
                .createdAt(student.getCreatedAt())
                .build();
    }

    public List<StudentResponseDto> getAllStudent(Integer age) {
        return studentRepository.findAllStudents(age)
                .stream()
                .map(StudentService::getStudentResponseDto).toList();
    }


//        StudentResponseDto studentResponseDto = new StudentResponseDto();
//        studentResponseDto.setName(student.getName());
//        studentResponseDto.setSurname(student.getSurname());
//        studentResponseDto.setId(student.getId());
//        studentResponseDto.setAge(student.getAge());
//        studentResponseDto.setCreatedAt(student.getCreatedAt());
//        return studentResponseDto; evezinde qisa yazilis


//       StudentResponseDto studentResponseDto=new StudentResponseDto();
//      studentResponseDto.setName(student.getName());
//      studentResponseDto.setSurname(student.getSurname());
//      studentResponseDto.setId(student.getId());
//      studentResponseDto.setAge(student.getAge());
//      studentResponseDto.setCreatedAt(student.getCreatedAt());
//        return studentResponseDto;
//    }


    //    public List<Student> getAllStudent(Integer age) {
//        return studentRepository.findAllStudents(age);
//    }
//
    public Student updateStudent(int id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Id yoxdur"));
            student.setName(studentDto.getName());
            student.setAge(studentDto.getAge());
            student.setSurname(studentDto.getSurname());
            student.setCreatedAt(LocalDateTime.now());
            studentRepository.save(student);
            return student;
    }


    //
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

//    public StudentDetail createStudentDetail(StudentDetail student) {
//        return studentDetailRepository.save(student);
//    }


    public List<Student> getAllStudentDetails() {
        return studentDetailRepository.findAllStudentDetail();
    }

    public StudentDetail createStudentDetail(StudentDetail student) {
        return null;
    }
}


