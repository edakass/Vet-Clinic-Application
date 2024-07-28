package vet_application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet_application.dto.UserRegistrationDto;
import vet_application.entity.Role;
import vet_application.entity.User;
import vet_application.repository.RoleRepository;
import vet_application.repository.UserRepository;
import vet_application.service.UserService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
