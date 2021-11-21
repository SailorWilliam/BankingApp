package ru.sakhnenko.spring.bankingapp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Поле должно содержать 2-30 символов")
    @NotBlank(message = "Поле не должно быть пустым!")
    private String name;

    @Column(name = "surname")
    @Size(min = 2, max = 30, message = "Поле должно содержать 2-30 символов")
    @NotBlank(message = "Поле не должно быть пустым!")
    private String surname;

    @Column(name = "middlename")
    @Size(min = 2, max = 30, message = "Поле должно содержать 2-30 символов")
    @NotBlank(message = "Поле не должно быть пустым!")
    private String middlename;

    @Column(name = "age")
    @Min(value = 18, message = "Клиентом банка можно стать с 18 лет")
    private int age;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "pin")
    private String pin;

    @Column(name = "balance")
    private int balance = 0;

    @Email
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "Номер должен иметь формат XXX-XXX-XX-XX")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "username")
    @Size(min = 6, max = 30, message = "Поле должно содержать 6-30 символов")
    @NotBlank(message = "Поле не должно быть пустым!")
    private String username;

    @Column(name = "password")
    @Size(min = 3, max = 70, message = "Поле должно содержать 3-50 символов")
    @NotBlank(message = "Поле не должно быть пустым!")
    private String password;

    private boolean active;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(cascade  = CascadeType.ALL, mappedBy = "client")
    private List<Operation> operations;

    public Client() {
    }

    public Client(String name, String surname, String middlename, int age, String cardNumber,
                  String pin, String email, String phoneNumber, String username,
                  String password, Manager manager, int balance) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.age = age;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.manager = manager;
        this.balance = balance;
    }

    public void addOperation(Operation operation) {
        if (operations == null) {
            operations = new ArrayList<>();
        }
        operations.add(operation);
        operation.setClient(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manager getManager() {
        return manager;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

}
