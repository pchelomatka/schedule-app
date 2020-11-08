package main.repositories;

import main.entities.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    Group findBySpecialityIdAndCourse(Integer specialityId, Integer course);

    Group findByName(String name);
}
