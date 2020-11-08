package main.services;

import main.entities.Group;
import main.repositories.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group getByName(String name) {
        return groupRepository.findByName(name);
    }

    public Group getGroupBySpecialityAndCourse(Integer speciality, Integer course) {
        return groupRepository.findBySpecialityIdAndCourse(speciality, course);
    }
}
