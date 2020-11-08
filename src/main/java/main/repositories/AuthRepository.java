package main.repositories;

import main.entities.Auth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Integer> {

    Auth findByLogin(Integer login);
}
