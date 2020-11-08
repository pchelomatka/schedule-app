package main.controllers;

import main.entities.Faculty;
import main.services.FacultyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping(value = "/faculties")
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }
}
