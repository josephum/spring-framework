package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="merchants")
@Data
@NoArgsConstructor
public class Merchant extends BaseEntity{

    private String code;
    private BigDecimal commissionRate;
    private String name;
    private int payoutDelayCount;
    private BigDecimal transactionFee;

    @OneToMany(mappedBy = "merchant") // In OneToMany the other entity Payment is parent side
    private List<Payment> paymentList;

    public Merchant(String code, String name, BigDecimal commissionRate, BigDecimal transactionFee,int payoutDelayCount) {
        this.code = code;
        this.commissionRate = commissionRate;
        this.name = name;
        this.payoutDelayCount = payoutDelayCount;
        this.transactionFee = transactionFee;
    }
}
