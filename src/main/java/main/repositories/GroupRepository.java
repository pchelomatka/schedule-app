package main.repositories;

import main.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Group findBySpecialityIdAndCourse(Integer specialityId, Integer course);
}
