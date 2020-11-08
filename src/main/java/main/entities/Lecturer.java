package main.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
@Data
public class Lecturer {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "student_subject_id")
    private Integer subjectId;
}
