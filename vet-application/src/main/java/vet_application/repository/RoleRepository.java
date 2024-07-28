package vet_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vet_application.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}