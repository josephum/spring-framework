package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer extends BaseEntity{

    private String userName;
    private String name;
    private String surname;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY) // LAZY is good for performance. Only when used
    private List<Payment> paymentList;                      // EAGER is fetching always

    public Customer(String userName, String name, String surname, String email, String address) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.paymentList = paymentList;
    }
}
