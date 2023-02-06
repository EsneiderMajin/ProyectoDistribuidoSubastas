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
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Product;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Personal
 */
public class ProductServices {
    private String endPoint;
    private Client objProductoPeticiones; 
	
    public ProductServices()
    {
	this.endPoint="http://localhost:5000/products/";
	this.objProductoPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Product registrarProducto(Product objProductRegistrar)
	{
            Product objProduct = null;

            WebTarget target = this.objProductoPeticiones.target(this.endPoint);

            Entity<Product> data = Entity.entity(objProductRegistrar, MediaType.APPLICATION_JSON_TYPE);

            Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

            objProduct = objPeticion.post(data, Product.class);

            return objProduct;
	}
    
    public List<Product> listarProducts()
	{
            List<Product> listaProducts = null;

            WebTarget target = this.objProductoPeticiones.target(this.endPoint);

            Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

            listaProducts = objPeticion.get(new GenericType<List<Product>>() {
            });

            return listaProducts;
	}
    
    public Product actualizarProducto(Product objProductoActualizar,Integer codigo)
	{
		Product  objProducto=null;		
		
		WebTarget target = this.objProductoPeticiones.target(this.endPoint).path(String.valueOf(codigo));	  
		
	    Entity<Product> data = Entity.entity(objProductoActualizar, MediaType.APPLICATION_JSON_TYPE);
	    
	    Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
	    
	    objProducto = objPeticion.put(data, Product.class);		
		
		return objProducto;
	}
    
    public Product consultarProducto(Integer codigo)
	{
		Product  objProducto=null;	
		
		WebTarget target = this.objProductoPeticiones.target(this.endPoint+codigo);
		
		Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	
		
		objProducto = objPeticion.get(Product.class);
		
		return objProducto;
	}
}
