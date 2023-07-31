package az.div.academy.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class StudentResponseDto {
    private String name;
    private  String surname;
    private Integer age;
@JsonFormat(pattern = "dd-MM-yyyy hh-mm-ss")
    private LocalDateTime createdAt;
}
