package main.controllers;

import main.entities.RequestScheduleGroup;
import main.entities.RequestScheduleSpeciality;
import main.entities.ResponseSchedule;
import main.services.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping(value = "/schedule/speciality", consumes = "application/json", produces = "application/json")
    public ResponseSchedule auth(@RequestBody RequestScheduleSpeciality requestScheduleFaculty) {
        return service.getScheduleSpeciality(requestScheduleFaculty);
    }

    @PostMapping(value = "/schedule/group", consumes = "application/json", produces = "application/json")
    public ResponseSchedule auth(@RequestBody RequestScheduleGroup requestScheduleGroup) {
        return service.getScheduleGroup(requestScheduleGroup);
    }

    @GetMapping(value = "/schedule/lecturer")
    public ResponseSchedule auth(@RequestParam String lecturer) {
        return service.getScheduleLecturer(lecturer);
    }

    @GetMapping(value = "/schedule/local")
    public ResponseSchedule auth(@RequestParam Integer login) {
        return service.getScheduleLocal(login);
    }
}
