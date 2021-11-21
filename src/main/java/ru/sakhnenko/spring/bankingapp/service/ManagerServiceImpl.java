package ru.sakhnenko.spring.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakhnenko.spring.bankingapp.entity.Manager;
import ru.sakhnenko.spring.bankingapp.repository.ManagerRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManager(int id) {
        return managerRepository.getById(id);
    }

    @Override
    public int getFreestManagerId() {
        List<Manager> allManagers = managerRepository.findAll();
        Collections.sort(allManagers);

        return allManagers.get(0).getId();
    }
}
