package main.services;

import main.entities.Speciality;
import main.repositories.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {

    final SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public List<Speciality> getSpecialitiesByFaculty(Integer facultyId) {
        return specialityRepository.findAllByFacultyId(facultyId);
    }
}
