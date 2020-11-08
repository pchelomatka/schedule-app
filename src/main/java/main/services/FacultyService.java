package main.services;

import main.entities.Faculty;
import main.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
