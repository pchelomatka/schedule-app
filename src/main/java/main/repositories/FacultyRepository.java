package main.repositories;

import main.entities.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

    List<Faculty> findAll();
}
