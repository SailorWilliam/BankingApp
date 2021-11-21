package ru.sakhnenko.spring.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.entity.Operation;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
    List<Operation> findOperationsByClient(Client client);
}
