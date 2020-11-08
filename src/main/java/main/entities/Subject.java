package main.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_subject")
@Data
public class Subject {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "classroom")
    private String classroom;
}
