package ru.sakhnenko.spring.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakhnenko.spring.bankingapp.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    public List<String> getRolesNames() {
        List<String> names = roleRepository.findAll().stream()
                .map(el -> el.getName()).collect(Collectors.toList());
        return names;
    }
}
