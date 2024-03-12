package jv.springbootsecuritybasics.repository;

import java.util.Optional;
import jv.springbootsecuritybasics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmaily(String email);
}
