package jee.project.Repository;

import jee.project.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);

    User findDistinctFirstByEmail(String email);
}

