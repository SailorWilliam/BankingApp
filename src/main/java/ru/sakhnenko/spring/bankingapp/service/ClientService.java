package ru.sakhnenko.spring.bankingapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.sakhnenko.spring.bankingapp.entity.Client;

import java.util.List;

public interface ClientService extends UserDetailsService {
    List<Client> getAllClients();

    boolean saveClient(Client client);

    void editClient(Client client);

    Client getClient(int id);

    Client getClientByCardNumber(String cardNumber);

    void deleteClient(int id);

    Client getClientByUsername(String username);
}
