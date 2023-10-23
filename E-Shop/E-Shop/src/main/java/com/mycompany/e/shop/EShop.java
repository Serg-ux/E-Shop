/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.e.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mazaira
 */
public class EShop {

    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        System.out.println("E-Shop ");
          int opcion;
        do {
            // Mostrar el menú
            System.out.println("(1) Ver productos");
            System.out.println("(2) Ver pedidos");
            System.out.println("(3) Ver dependientes");
            System.out.println("(0) Salir");
             System.out.println("-------------------------");
            System.out.print("Por favor, elige una opción: ");

            // Leer la opción del usuario
            opcion = read.nextInt();

            // Manejar la opción del usuario utilizando un switch
            switch (opcion) {
                case 1:
                    System.out.println("Mostrando lista de productos...");
                    System.out.println("-------------------------");
                    // Crear una lista de productos
                    List<Product> productList = new ArrayList<>();

                    // Agregar productos a la lista
                    Product product1 = new Product(1, "Product 1", "Description 1", 19.99, 50);
                    Product product2 = new Product(2, "Product 2", "Description 2", 29.99, 30);
                    Product product3 = new Product(3, "Product 3", "Description 3", 9.99, 12);

                    productList.add(product1);
                    productList.add(product2);
                    productList.add(product3);

                    // Mostrar los productos
                    System.out.println("Lista de Productos:");
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getProductId());
                        System.out.println("Nombre: " + product.getName());
                        System.out.println("Descripción: " + product.getDescription());
                        System.out.println("Precio: $" + product.getPrice());
                        System.out.println("Cantidad en Stock: " + product.getQuantityInStock());
                        // Calcular el valor total del producto
                        double totalValue = product1.calculateTotalValue();
                        // Representar el valor total del producto
                        System.out.println("Valor total del producto: " + totalValue +" €");
                        System.out.println("-------------------------");
                    }
                    break;
                case 2:
                    System.out.println("Mostrando lista de pedidos...");
                    // Lógica para ver pedidos
                    break;
                case 3:
                    System.out.println("Mostrando lista de dependientes...");
                    // Lógica para ver dependientes
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } while (opcion != 0); // Repetir el bucle hasta que el usuario elija salir (opción 0)
        
        // Cerrar el scanner
        read.close();
        
        
        // Creación de Objetos Producto
        Product product1 = new Product(1, " Producto 1", "Descripcción del producto de ejemplo 1", 32.50, 42);
        Product product2 = new Product(2, "Producto 2", "Descripcción del producto de ejemplo 2", 29.99, 35);
        // Crear un objeto Dependiente
        Customer customer = new Customer(1, "Customer 1", "customer1@example.com");
        // Crear un objeto pedido
        Order order = new Order(1, customer.getName());
        
        // Calcular el valor total del producto
        double totalValue = product1.calculateTotalValue();
        System.out.println(product1.toString());
        System.out.println("");
        System.out.println("");
        // Representar el valor total del producto
        System.out.println("Valor total del producto: " + totalValue +" €");

        // Añadir productos al pedido
        order.addProductToOrder(product1, 2); // Añadir 2 unidades del producto 1 al pedido
        order.addProductToOrder(product2, 1); // Añadir 1 unidad del producto 2 al pedido
        
        // Colocar el pedido en el dependiente
        customer.placeOrder(order);

        // Representar la información del dependiente y su historial del pedidos
        System.out.println(customer.toString());
    }
}
