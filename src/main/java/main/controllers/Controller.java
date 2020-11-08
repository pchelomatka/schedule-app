package main.controllers;

import main.entities.*;
import main.services.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
    public void auth(@RequestBody RequestAuth requestAuth, HttpServletResponse httpServletResponse) {
        service.auth(requestAuth, httpServletResponse);
    }

    @GetMapping(value = "/logout")
    public void logout(@RequestParam Integer login, HttpServletResponse httpServletResponse) {
        service.logout(login, httpServletResponse);
    }

    @GetMapping(value = "/faculties")
    public List<Faculty> getAllFaculties() {
        return service.getAllFaculties();
    }

    @GetMapping(value = "/speciality/{facultyId}")
    public List<Speciality> getSpecialitiesByFaculty(@PathVariable Integer facultyId) {
        return service.getSpecialitiesByFaculty(facultyId);
    }

    @PostMapping(value = "/schedule/speciality", consumes = "application/json", produces = "application/json")
    public ResponseScheduleSpeciality auth(@RequestBody RequestScheduleSpeciality requestScheduleFaculty) {
        return service.getScheduleSpeciality(requestScheduleFaculty);
    }
}
