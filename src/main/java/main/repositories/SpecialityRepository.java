package main.repositories;

import main.entities.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Integer> {

    List<Speciality> findAllByFacultyId(Integer facultyId);
}
