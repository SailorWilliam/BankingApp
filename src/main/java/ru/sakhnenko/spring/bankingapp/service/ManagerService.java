package ru.sakhnenko.spring.bankingapp.service;

import ru.sakhnenko.spring.bankingapp.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManagers();

//    public void saveManager(Manager manager);

    Manager getManager(int id);

    int getFreestManagerId();

//    public void deleteManager(int id);
}
