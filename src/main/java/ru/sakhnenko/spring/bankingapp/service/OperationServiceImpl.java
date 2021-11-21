package ru.sakhnenko.spring.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.entity.Operation;
import ru.sakhnenko.spring.bankingapp.repository.OperationRepository;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    OperationRepository operationRepository;

    @Override
    public List<Operation> getAllOperation() {
        return operationRepository.findAll();
    }

    @Override
    public List<Operation> getAllOperationByClient(Client client) {
        return operationRepository.findOperationsByClient(client);
    }
}
