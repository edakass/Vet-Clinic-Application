package vet_application.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vet_application.dto.UserRegistrationDto;
import vet_application.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(userDto);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}