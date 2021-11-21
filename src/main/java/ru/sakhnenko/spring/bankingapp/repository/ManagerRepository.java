package ru.sakhnenko.spring.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.bankingapp.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
