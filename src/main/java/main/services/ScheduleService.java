package main.services;

import main.entities.RequestScheduleGroup;
import main.entities.RequestScheduleSpeciality;
import main.entities.ResponseSchedule;
import main.entities.Schedule;
import main.repositories.ScheduleRepository;
import main.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    final ScheduleRepository scheduleRepository;
    final LecturerService lecturerService;
    final SubjectService subjectService;
    final GroupService groupService;
    final StudentService studentService;
    final Util util;

    public ScheduleService(ScheduleRepository scheduleRepository, LecturerService lecturerService, SubjectService subjectService, GroupService groupService, StudentService studentService, Util util) {
        this.scheduleRepository = scheduleRepository;
        this.lecturerService = lecturerService;
        this.subjectService = subjectService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.util = util;
    }

    public ResponseSchedule getScheduleSpeciality(RequestScheduleSpeciality requestScheduleSpeciality) {
        ResponseSchedule responseSchedule = new ResponseSchedule();
        List<Schedule> scheduleList = scheduleRepository.findAllByStudentGroupId(groupService.getGroupBySpecialityAndCourse(
                requestScheduleSpeciality.getSpecId(),
                requestScheduleSpeciality.getCourse())
                .getSpecialityId());

        if (requestScheduleSpeciality.getWeek() == null) {
            responseSchedule.setFirstWeek(util.fillWeek(scheduleList, 1));
            responseSchedule.setSecondWeek(util.fillWeek(scheduleList, 2));
        } else if (requestScheduleSpeciality.getWeek().equals(1)) {
            responseSchedule.setFirstWeek(util.fillWeek(scheduleList, 1));
        } else {
            responseSchedule.setSecondWeek(util.fillWeek(scheduleList, 2));
        }
        return responseSchedule;
    }

    public ResponseSchedule getScheduleGroup(RequestScheduleGroup requestScheduleGroup) {
        ResponseSchedule responseSchedule = new ResponseSchedule();
        List<Schedule> scheduleList = scheduleRepository
                .findAllByStudentGroupId(groupService.getByName(requestScheduleGroup.getGroup()).getId());

        if (requestScheduleGroup.getWeek() == null) {
            responseSchedule.setFirstWeek(util.fillWeek(scheduleList, 1));
            responseSchedule.setSecondWeek(util.fillWeek(scheduleList, 2));
        } else if (requestScheduleGroup.getWeek().equals(1)) {
            responseSchedule.setFirstWeek(util.fillWeek(scheduleList, 1));
        } else {
            responseSchedule.setSecondWeek(util.fillWeek(scheduleList, 2));
        }
        return responseSchedule;
    }

    public ResponseSchedule getScheduleLecturer(String lecturer) {
        ResponseSchedule responseSchedule = new ResponseSchedule();
        List<Schedule> scheduleList = scheduleRepository
                .findAllByStudentSubjectIdIn(lecturerService.getAllSubjectsId(lecturer));
        responseSchedule.setFirstWeek(util.fillWeek(scheduleList, 1));
        responseSchedule.setSecondWeek(util.fillWeek(scheduleList, 2));
        return responseSchedule;
    }

    public ResponseSchedule getScheduleLocal(Integer login) {
        ResponseSchedule responseSchedule = new ResponseSchedule();
        List<Schedule> scheduleList = scheduleRepository
                .findAllByStudentGroupId(studentService.getStudent(login).getGroupId());
        responseSchedule.setFirstWeek(util.fillWeek(scheduleList, 1));
        responseSchedule.setSecondWeek(util.fillWeek(scheduleList, 2));
        return responseSchedule;
    }
}
