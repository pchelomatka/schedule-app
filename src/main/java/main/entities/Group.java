package main.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_group")
@Data
public class Group {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private Integer course;

    @Column(name = "speciality_id")
    private Integer specialityId;
}
