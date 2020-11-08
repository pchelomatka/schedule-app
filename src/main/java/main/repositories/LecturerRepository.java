package main.repositories;

import main.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {

    Lecturer findBySubjectId(Integer subjectId);

    List<Lecturer> findAllByName(String name);
}
