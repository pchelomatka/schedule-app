package main.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
@Data
public class Schedule {

    @Id
    private Integer id;

    @Column(name = "student_group_id")
    private Integer studentGroupId;

    @Column(name = "student_subject_id")
    private Integer studentSubjectId;

    @Column(name = "week")
    private Integer week;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "number_of_pair")
    private Integer number;
}
