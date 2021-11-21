package ru.sakhnenko.spring.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.service.ClientService;
import ru.sakhnenko.spring.bankingapp.service.ManagerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String mainAdminPage() {
        return "admin/admin-page";
    }

    @GetMapping("/clients")
    public String showAllClients(Model model) {
        model.addAttribute("allClients", clientService.getAllClients());
        return "admin/all-clients";
    }

    @GetMapping("/managers")
    public String showAllManagers(Model model) {
        model.addAttribute("allManagers", managerService.getAllManagers());
        return "admin/all-managers";
    }

    @PostMapping("/clients/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return "redirect:/admin/clients";
    }

//    @GetMapping("/clients/{id}")
//    public String editClient(@PathVariable int id, Model model) {
//        model.addAttribute("client", clientService.getClient(id));
//        return "admin/edit-client";
//    }
//
//    @PatchMapping ("/clients/{id}")
//    public String updateClient(@ModelAttribute("client") @Valid Client client,
//                         BindingResult bindingResult, @PathVariable int id) {
//        if (bindingResult.hasErrors()) {
//            return "admin/edit-client";
//        }
//        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
//        clientService.saveClient(client);
//        return "redirect:/admin/edit-client";
//    }
}

