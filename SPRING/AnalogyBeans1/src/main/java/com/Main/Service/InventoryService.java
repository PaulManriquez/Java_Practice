package com.Main.Service;

import org.springframework.stereotype.Component;

@Component
public class InventoryService {

    public void checkStockSystem() {
        System.out.println("📡 Connecting to inventory system...");
    }

    public void reserveItem() {
        System.out.println("📦 Reserving item in inventory.");
    }

    public void close() {
        System.out.println("📴 Disconnecting from inventory system.");
    }
}