package ru.sakhnenko.spring.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements  ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public boolean saveClient(Client client) {
        Client clientFromDB = clientRepository.findByUsername(client.getUsername());
        if (clientFromDB != null) {
            return false;
        }

        clientRepository.save(client);
        return true;
    }

    @Override
    public void editClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client getClientByCardNumber(String cardNumber) {
        return clientRepository.findClientByCardNumber(cardNumber);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findByUsername(username);
    }
}
