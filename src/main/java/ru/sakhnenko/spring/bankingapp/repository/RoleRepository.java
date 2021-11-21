package ru.sakhnenko.spring.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.bankingapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
    Role findByName(String name);
}
