package main.services;

import main.entities.Student;
import main.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
