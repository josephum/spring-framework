package com.example.bootstrap;


import com.example.entity.*;
import com.example.enums.PaymentStatus;
import com.example.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    PaymentRepository paymentRepository;
    MerchantRepository merchantRepository;
    CustomerRepository customerRepository;
    CartRepository cartRepository;
    ItemRepository itemRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, CartRepository cartRepository, ItemRepository itemRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Payment p1 = new Payment(BigDecimal.valueOf(3123.4213), LocalDate.of(2006,04,20), PaymentStatus.PROCESSING);
//        Payment p2 = new Payment(BigDecimal.valueOf(3123.4213), LocalDate.of(2006,04,20), PaymentStatus.PROCESSING);

        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), PaymentStatus.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), PaymentStatus.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        merchantRepository.save(merchant1);

        Customer customer1 = new Customer("msmith","mike","smith","mike@cydeo.com","VA");

        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);

        customerRepository.save(customer1);


        Item item1 = new Item("Milk","M01");
        Item item2 = new Item("Sugar","S01");
        Item item3 = new Item("Bread","B01");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cart1.setItemList(Arrays.asList(item1,item2,item3));
        cart2.setItemList(Arrays.asList(item1,item2));

        cartRepository.save(cart1);
        cartRepository.save(cart2);


        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}
