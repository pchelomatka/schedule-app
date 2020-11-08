package main.services;

import main.entities.Subject;
import main.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject getSubject(Integer subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }
}
