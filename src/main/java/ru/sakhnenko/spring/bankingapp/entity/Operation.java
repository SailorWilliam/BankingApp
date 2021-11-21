package ru.sakhnenko.spring.bankingapp.entity;

import ru.sakhnenko.spring.bankingapp.enums.OperationType;

import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OperationType type;

    @Column(name = "sum")
    private int sum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    public Operation() {
    }

    public Operation(String time, OperationType type, int sum) {
        this.time = time;
        this.type = type;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
