package com.Main.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private InventoryService inventoryService;

    //* I suppose that if something goes wrong in this phase, we can raise an error
    @PostConstruct
    public void startUpCheck(){//Dependencies are inyected but before check if everything goes well
        System.out.println("Order Service is starting up ");
        paymentService.checkConnection();
        inventoryService.checkStockSystem();
        System.out.println("All systems are ready to go in OrderService");
    }

    public void placeOrder(){
        System.out.println("✅ Placing an order...");
        paymentService.processPayment();
        inventoryService.reserveItem();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Order service is shutting down");
        paymentService.close();
        inventoryService.close();
    }

}
