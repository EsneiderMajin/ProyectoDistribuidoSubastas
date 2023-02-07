/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Products;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author juanc
 */
public class ProductServices {
    private String endPoint;
    private Client objClientePeticiones; 
	
    public ProductServices()
    {
	this.endPoint="http://localhost:5000/products/";
	this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
        
    public Products consultarProduct(int code)
    {
            Products  objProduct=null;	

            WebTarget target = this.objClientePeticiones.target(this.endPoint+code);

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	

            objProduct = objPeticion.get(Products.class);

            return objProduct;
    }


    public List<Products> listarProduct()
    {
            List<Products> listaProduct=null;			

            WebTarget target = this.objClientePeticiones.target(this.endPoint);

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON);

            listaProduct = objPeticion.get(new GenericType<List<Products>>() {});	

            return listaProduct;
    }


    public Products registrarProduct(Products objproductsRegistar)
    {
            Products  objProduct=null;

            WebTarget target = this.objClientePeticiones.target(this.endPoint);	    

        Entity<Products> data = Entity.entity(objproductsRegistar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);

        objProduct = objPeticion.post(data, Products.class);		

            return objProduct;
    }

    public Products actualizarProduct(Products objproductActualizar,Integer id)
    {
            Products  objCliente=null;		

            WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);	  

        Entity<Products> data = Entity.entity(objproductActualizar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.put(data, Products.class);		

            return objCliente;
    }


    public Boolean eliminarProduct(Integer id)
    {
            Boolean bandera=false;

            WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);	    

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);

            bandera = objPeticion.delete(Boolean.class);

            return bandera;
    }    
}
