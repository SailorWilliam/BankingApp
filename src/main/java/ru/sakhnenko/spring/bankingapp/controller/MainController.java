package ru.sakhnenko.spring.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.entity.Role;
import ru.sakhnenko.spring.bankingapp.repository.ClientRepository;
import ru.sakhnenko.spring.bankingapp.repository.RoleRepository;
import ru.sakhnenko.spring.bankingapp.service.ClientService;
import ru.sakhnenko.spring.bankingapp.service.ManagerService;
import ru.sakhnenko.spring.bankingapp.util.CardGenerator;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class MainController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("clientForm", new Client());
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewClient(@ModelAttribute("clientForm") @Valid Client clientForm,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        clientForm.setCardNumber(CardGenerator.generateCardNumber(clientRepository));
        clientForm.setPin(CardGenerator.generatePin());
        clientForm.setManager(managerService.getManager(managerService.getFreestManagerId()));
        clientForm.setActive(true);
        clientForm.setPassword(bCryptPasswordEncoder.encode(clientForm.getPassword()));
        clientForm.setRoles(Collections.singleton(roleRepository.findById(1)));

        if (!clientService.saveClient(clientForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirect:/";
    }

    @GetMapping("/login_redirect")
    public String redirectByRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.getClientByUsername(auth.getName());
        for(Role role: client.getRoles()) {
            if (role.getName().equals("ROLE_ADMIN")) {
                return "redirect:/admin/";
            } else if (role.getName().equals("ROLE_USER")) {
                return "redirect:/client/";
            }
        }
        return "redirect:/";
    }
}
