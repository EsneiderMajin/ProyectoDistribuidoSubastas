/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import models.Products;

/**
 *
 * @author juanc
 */
public class HiloAlterno extends Thread {
    private int code;
    private ProductServices objProductoServices;
    
    public HiloAlterno(int code, ProductServices objProductoServices){
        this.code = code;
        this.objProductoServices = objProductoServices;
    }
    
    @Override
    public void run() {
        while (true) {
            Products producto = objProductoServices.consultarProduct(code);
            System.out.println("Refrescando...");
            System.out.println("Code: " + producto.getCode());
            System.out.println("Nombre: " + producto.getName());
            System.out.println("Value: " + producto.getInitValue());
            System.out.println("State: " + producto.getState());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
