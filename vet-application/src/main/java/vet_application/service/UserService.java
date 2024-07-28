package vet_application.service;

import vet_application.dto.UserRegistrationDto;
import vet_application.entity.User;

import java.util.Optional;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
    Optional<User> findByUsername(String username);
}