package ru.sakhnenko.spring.bankingapp.service;


import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.entity.Operation;

import java.util.List;

public interface OperationService {
    List<Operation> getAllOperation();

    List<Operation> getAllOperationByClient(Client client);

}
