package az.div.academy.model.mapper;

import az.div.academy.model.dto.StudentDto;
import az.div.academy.model.dto.StudentResponseDto;
import az.div.academy.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
     Student toStudent(StudentDto studentDto);
     StudentResponseDto toStudentResponse(Student student);
}
