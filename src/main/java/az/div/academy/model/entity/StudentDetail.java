package az.div.academy.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "student_detail")
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "group_number")
    private Integer groupNumber;
    @Column(name = "group_prefix")
    private String groupPrefix;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")


//    private Integer studentId; change to >>
//bele deyishdiyimiz halda student id (name, surname, age, createt_at ve s.hamisini)icherisinde her sheyi obyekt kimi qaytarir postmanda.)

    private Student student;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}



