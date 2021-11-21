package ru.sakhnenko.spring.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sakhnenko.spring.bankingapp.entity.Client;
import ru.sakhnenko.spring.bankingapp.entity.Operation;
import ru.sakhnenko.spring.bankingapp.enums.OperationType;
import ru.sakhnenko.spring.bankingapp.service.ClientService;
import ru.sakhnenko.spring.bankingapp.service.ManagerService;
import ru.sakhnenko.spring.bankingapp.service.OperationService;

import java.util.Date;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private OperationService operationService;

    @GetMapping("/")
    public String getClientInfo(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("client", clientService.getClientByUsername(auth.getName()));
        return "client/client-info";
    }

    @GetMapping("/managers/{id}")
    public String getManagerInfo(@PathVariable int id, Model model) {
        model.addAttribute("manager", managerService.getManager(id));
        return "client/manager-info";
    }

    @GetMapping ("/replenishment")
    public String replenishment() {
        return "client/replenishment";
    }

    @PostMapping("/replenishment")
    public String topUpClientBalance(@RequestParam int sum, Model model) {
        if (sum < 1) {
            model.addAttribute("negativeSumError", "Сумма должна быть больше 0");
            return "client/replenishment";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.getClientByUsername(auth.getName());
        client.setBalance(client.getBalance() + sum);
        Operation operation = new Operation(new Date().toString(), OperationType.REPLENISHMENT, sum);
        client.addOperation(operation);
        clientService.editClient(client);

        return "redirect:/client/";
    }

    @GetMapping ("/transfer")
    public String getTransferView() {
        return "client/transfer";
    }

    @PostMapping ("/transfer")
    public String makeTransfer(@RequestParam String cardNumber,
                               @RequestParam int sum, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client clientSender = clientService.getClientByUsername(auth.getName());

        if (clientSender.getCardNumber().equals(cardNumber)) {
            model.addAttribute("sameCardError", "Вы не можете перевести средства на свою карту");
            return "client/transfer";
        }
        if (sum < 1) {
            model.addAttribute("negativeSumError", "Сумма должна быть больше 0");
            return "client/transfer";
        }
        if (sum > clientSender.getBalance()) {
            model.addAttribute("sumError", "Недостаточно средств");
            return "client/transfer";
        }

        Client clientRecipient  = clientService.getClientByCardNumber(cardNumber);

        if (clientRecipient == null) {
            model.addAttribute("cardNumberError", "Неверно указан номер карты");
            return "client/transfer";
        }

        clientSender.setBalance(clientSender.getBalance() - sum);
        clientSender.addOperation(new Operation(new Date().toString(), OperationType.TRANSFER, sum));
        clientService.editClient(clientSender);

        clientRecipient.setBalance(clientRecipient.getBalance() + sum);
        clientRecipient.addOperation(new Operation(new Date().toString(), OperationType.RECEIPT, sum));
        clientService.editClient(clientRecipient);

        return "redirect:/client/";
    }

    @GetMapping("/history")
    public String getClientHistory(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.getClientByUsername(auth.getName());
        model.addAttribute("allOperations", operationService.getAllOperationByClient(client));
        return "client/history";
    }
}
