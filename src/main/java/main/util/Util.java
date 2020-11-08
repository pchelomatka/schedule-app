package main.util;

import main.entities.*;
import main.services.LecturerService;
import main.services.SubjectService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Util {

    List<String> daysOfWeek = new ArrayList<>(Arrays.asList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб"));

    private final SubjectService subjectService;
    private final LecturerService lecturerService;

    public Util(SubjectService subjectService, LecturerService lecturerService) {
        this.subjectService = subjectService;
        this.lecturerService = lecturerService;
    }

    public List<Day> fillWeek(List<Schedule> scheduleList, Integer typeOfWeek) {
        List<Day> week = new ArrayList<>();
        for (String dayOfWeek : daysOfWeek) {
            List<Schedule> filteredScheduleFirstWeek = scheduleList.stream()
                    .filter(x -> x.getDayOfWeek().equals(dayOfWeek) && x.getWeek().equals(typeOfWeek))
                    .collect(Collectors.toList());

            Day day = new Day();
            day.setWeekday(dayOfWeek);
            List<Pair> pairs = new ArrayList<>();
            for (Schedule schedule : filteredScheduleFirstWeek) {
                Subject subject = subjectService.getSubject(schedule.getStudentSubjectId());
                Lecturer lecturer = lecturerService.getLecturerBySubjectId(schedule.getStudentSubjectId());
                Pair pair = new Pair();
                pair.setNumber(schedule.getNumber());
                pair.setName(subject.getName());
                pair.setLecturer(lecturer.getName());
                pair.setClassroom(subject.getClassroom());
                pairs.add(pair);
            }
            day.setPairs(pairs);
            week.add(day);
        }
        week = week.stream().filter(x -> !x.getPairs().isEmpty()).collect(Collectors.toList());
        return week;
    }
}
