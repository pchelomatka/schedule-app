package main.services;

import main.entities.Lecturer;
import main.repositories.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public Lecturer getLecturerBySubjectId(Integer subjectId) {
        return lecturerRepository.findBySubjectId(subjectId);
    }

    public List<Integer> getAllSubjectsId(String name) {
        List<Integer> result = new ArrayList<>();
        List<Lecturer> lecturerList = lecturerRepository.findAllByName(name);
        for (Lecturer lecturer : lecturerList) {
            result.add(lecturer.getSubjectId());
        }
        return result;
    }
}
