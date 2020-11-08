package main.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "student_group_id")
    private Integer groupId;

}
