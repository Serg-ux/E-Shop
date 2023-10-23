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

public class Order {
    // Atributos
    private int orderId;
    private String customerName;
    private List<Product> orderedProducts;
    private double totalOrderValue;

    // Constructores
    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderedProducts = new ArrayList<>();
        this.totalOrderValue = 0.0;
    }

    // Getters y Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public double getTotalOrderValue() {
        return totalOrderValue;
    }

    // Método para añadir productos al pedido y sumar la cantidad total del pedido
    public void addProductToOrder(Product product, int quantity) {
        if (product != null && quantity > 0 && product.getQuantityInStock() >= quantity) {
            boolean productFound = false;

            for (Product orderedProduct : orderedProducts) {
                if (orderedProduct.getProductId() == product.getProductId()) {
                    // Si el producto ya está en el pedido, actualizar la cantidad
                    int newQuantity = orderedProduct.getQuantityInStock() >= quantity ? quantity : orderedProduct.getQuantityInStock();
                    orderedProduct.setQuantityInStock(orderedProduct.getQuantityInStock() - newQuantity);
                    productFound = true;
                    break;
                }
            }

            // Si el producto no está en el pedido, agregarlo con la cantidad especificada
            if (!productFound) {
                if (product.getQuantityInStock() >= quantity) {
                    Product productCopy = new Product(product.getProductId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantityInStock());
                    orderedProducts.add(productCopy);
                    product.setQuantityInStock(product.getQuantityInStock() - product.getQuantityInStock());
                }
            }

            // Calcular el valor total del pedido
            totalOrderValue += product.getPrice() * quantity;
        }
    }
    //Método para coger la cantidad de un producto en el pedido
   private int quantityInOrder(Product product) {
        int quantity = 0;
        for (Product orderedProduct : orderedProducts) {
            if (orderedProduct.getProductId() == product.getProductId()) {
                quantity++;
            }
        }
        return quantity;
    }
    
    // representar el objeto pedido como String
    @Override
    public String toString() {
        StringBuilder productsInfo = new StringBuilder();
        for (Product product : orderedProducts) {
            productsInfo.append("\n").append(product.getName()).append(" (Quantity: ").append(quantityInOrder(product)).append(")");
        }

        return "Order ID: " + orderId +
               "\nCustomer Name: " + customerName +
               "\nOrdered Products:" + productsInfo +
               "\nTotal Order Value: $" + totalOrderValue;
    }
}

