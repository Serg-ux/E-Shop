/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.shop;

/**
 *
 * @author Mazaira
 */
public class Product {
    // Atributos
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;

    // Constructores
    public Product(int productId, String name, String description, double price, int quantityInStock) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Métodos Getters y Setters 
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
   
    //Método para calcular el valor total de los productos
    public double calculateTotalValue() {
        return price * quantityInStock;
    }
    
    // Representar el objeto como String
    @Override
    public String toString() {
        return "Product ID: " + productId +
               "\nName: " + name +
               "\nDescription: " + description +
               "\nPrice: $" + price +
               "\nQuantity in Stock: " + quantityInStock;
    }
}
