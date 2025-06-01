package com.Main.Service;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void checkConnection() {
        System.out.println("🔎 Verifying payment gateway connection...");
    }

    public void processPayment() {
        System.out.println("💳 Processing payment...");
    }

    public void close() {
        System.out.println("🔒 Closing payment service connection.");
    }
}