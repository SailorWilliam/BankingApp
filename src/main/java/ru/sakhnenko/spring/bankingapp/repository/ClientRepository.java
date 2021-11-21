package ru.sakhnenko.spring.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sakhnenko.spring.bankingapp.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findClientByCardNumber(String cardNumber);

    Client findByUsername(String username);
}
