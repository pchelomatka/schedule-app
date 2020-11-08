package main.repositories;

import main.entities.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

    List<Schedule> findAllByStudentGroupId(Integer groupId);

    List<Schedule> findAllByStudentSubjectIdIn(List<Integer> subjectId);
}
