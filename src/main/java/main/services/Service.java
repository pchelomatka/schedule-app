package main.services;

import main.entities.*;
import main.repositories.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    List<String> daysOfWeek = new ArrayList<>(Arrays.asList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб"));

    final AuthRepository authRepository;
    final FacultyRepository facultyRepository;
    final SpecialityRepository specialityRepository;
    final ScheduleRepository scheduleRepository;
    final GroupRepository groupRepository;
    final SubjectRepository subjectRepository;
    final LecturerRepository lecturerRepository;

    public Service(AuthRepository authRepository, FacultyRepository facultyRepository, SpecialityRepository specialityRepository, ScheduleRepository scheduleRepository, GroupRepository groupRepository, SubjectRepository subjectRepository, LecturerRepository lecturerRepository) {
        this.authRepository = authRepository;
        this.facultyRepository = facultyRepository;
        this.specialityRepository = specialityRepository;
        this.scheduleRepository = scheduleRepository;
        this.groupRepository = groupRepository;
        this.subjectRepository = subjectRepository;
        this.lecturerRepository = lecturerRepository;
    }

    public void auth(RequestAuth requestAuth, HttpServletResponse httpServletResponse) {
        Auth auth = authRepository.findByLogin(requestAuth.getLogin());
        if (!(auth == null) && auth.getPassword().equals(requestAuth.getPassword())) {
            auth.setAuthFlag(true);
            authRepository.save(auth);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    public void logout(Integer login, HttpServletResponse httpServletResponse) {
        Auth auth = authRepository.findByLogin(login);
        auth.setAuthFlag(false);
        authRepository.save(auth);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<Speciality> getSpecialitiesByFaculty(Integer facultyId) {
        return specialityRepository.findAllByFacultyId(facultyId);
    }

    public ResponseScheduleSpeciality getScheduleSpeciality(RequestScheduleSpeciality requestScheduleSpeciality) {
        ResponseScheduleSpeciality responseScheduleSpeciality = new ResponseScheduleSpeciality();
        List<Day> week = new ArrayList<>();
        List<Schedule> scheduleList = scheduleRepository
                .findAllByStudentGroupId(groupRepository
                        .findBySpecialityIdAndCourse(
                                requestScheduleSpeciality.getSpecId(),
                                requestScheduleSpeciality.getCourse())
                        .getSpecialityId());

        if (requestScheduleSpeciality.getWeek() == null) {
            responseScheduleSpeciality.setFirstWeek(fillWeek(scheduleList, week, 1));
            responseScheduleSpeciality.setSecondWeek(fillWeek(scheduleList, week, 2));
        } else {
            switch (requestScheduleSpeciality.getWeek()) {
                case 1:
                    responseScheduleSpeciality.setFirstWeek(fillWeek(scheduleList, week, 1));
                    break;
                case 2:
                    responseScheduleSpeciality.setSecondWeek(fillWeek(scheduleList, week, 2));
                    break;
            }
        }
        return responseScheduleSpeciality;
    }

    private List<Day> fillWeek(List<Schedule> scheduleList, List<Day> week, Integer typeOfWeek) {
        for (String dayOfWeek : daysOfWeek) {
            List<Schedule> filteredScheduleFirstWeek = scheduleList.stream()
                    .filter(x -> x.getDayOfWeek().equals(dayOfWeek) && x.getWeek().equals(typeOfWeek))
                    .collect(Collectors.toList());

            Day day = new Day();
            day.setWeekday(dayOfWeek);
            List<Pair> pairs = new ArrayList<>();
            for (Schedule schedule : filteredScheduleFirstWeek) {
                Subject subject = subjectRepository.getOne(schedule.getStudentSubjectId());
                Lecturer lecturer = lecturerRepository.findBySubjectId(schedule.getStudentSubjectId());
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
