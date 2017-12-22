package jeeproject.jeeproject.Repository;

import jeeproject.jeeproject.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

