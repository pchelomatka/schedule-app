package main.controllers;

import main.entities.Speciality;
import main.services.SpecialityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialityController {

    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping(value = "/speciality/{facultyId}")
    public List<Speciality> getSpecialitiesByFaculty(@PathVariable Integer facultyId) {
        return specialityService.getSpecialitiesByFaculty(facultyId);
    }

}
