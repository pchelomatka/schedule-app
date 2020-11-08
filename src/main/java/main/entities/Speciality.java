package main.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "speciality")
@Data
public class Speciality {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "faculty_id")
    private Integer facultyId;
}
