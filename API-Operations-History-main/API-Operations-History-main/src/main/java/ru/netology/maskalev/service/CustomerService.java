package ru.netology.maskalev.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.netology.maskalev.domain.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Getter
@Component
public class CustomerService {
    private final ArrayList<Customer> customers;

    public CustomerService(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Customer addCustomer(Customer item) {
        customers.add(item);
        return item;
    }

    @PostConstruct
    public void initStorage() {
        customers.add(new Customer(1, "Spring"));
        customers.add(new Customer(2, "Boot"));
    }
}