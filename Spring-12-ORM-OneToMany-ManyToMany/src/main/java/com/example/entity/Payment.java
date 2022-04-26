package com.example.entity;

import com.example.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name= "payments")
@NoArgsConstructor
@Data
public class Payment extends BaseEntity{


    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    public Payment(LocalDate createdDate, BigDecimal amount, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }

}
