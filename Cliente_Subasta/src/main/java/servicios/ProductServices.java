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
import models.Product;
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
        
    public Product consultarProduct(int code)
    {
            Product  objProduct=null;	

            WebTarget target = this.objClientePeticiones.target(this.endPoint+code);

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	

            objProduct = objPeticion.get(Product.class);

            return objProduct;
    }


    public List<Product> listarProduct()
    {
            List<Product> listaProduct=null;			

            WebTarget target = this.objClientePeticiones.target(this.endPoint);

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON);

            listaProduct = objPeticion.get(new GenericType<List<Product>>() {});	

            return listaProduct;
    }


    public Product registrarProduct(Product objproductsRegistar)
    {
            Product  objProduct=null;

            WebTarget target = this.objClientePeticiones.target(this.endPoint);	    

        Entity<Product> data = Entity.entity(objproductsRegistar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);

        objProduct = objPeticion.post(data, Product.class);		

            return objProduct;
    }

    public Product actualizarProduct(Product objproductActualizar,Integer id)
    {
            Product  objCliente=null;		

            WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);	  

        Entity<Product> data = Entity.entity(objproductActualizar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.put(data, Product.class);		

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
    
    public Product consultarProductSubasta()
    {
            Product  objProduct=null;	

            WebTarget target = this.objClientePeticiones.target(this.endPoint+"state");

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	

            objProduct = objPeticion.get(Product.class);

            return objProduct;
    }
}
