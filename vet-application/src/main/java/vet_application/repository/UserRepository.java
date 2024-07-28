package vet_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vet_application.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
