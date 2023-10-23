/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.shop;

/**
 *
 * @author Mazaira
 */
import java.util.ArrayList;
import java.util.List;

public class Customer {
    // Atributos
    private int customerId;
    private String name;
    private String email;
    private List<Order> orderHistory;

    // Constructores
    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.orderHistory = new ArrayList<>();
    }

    // Getters y Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    
    // Método para poner un pedido en un dependiente y actualizar su historial de pedidos
    public void placeOrder(Order order) {
        if (order != null) {
            orderHistory.add(order);
        }
    }

    // Método para representar el objeto como String
    @Override
    public String toString() {
        StringBuilder orderHistoryInfo = new StringBuilder();
        for (Order order : orderHistory) {
            orderHistoryInfo.append("\n").append(order.toString());
        }

        return "Customer ID: " + customerId +
               "\nName: " + name +
               "\nEmail: " + email +
               "\nOrder History:" + orderHistoryInfo;
    }
}

