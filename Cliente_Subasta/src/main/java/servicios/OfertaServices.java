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
import models.Offer;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Personal
 */
public class OfertaServices {
    private String endPoint;
    private Client objClientePeticiones; 
	
    public OfertaServices()
    {
	this.endPoint="http://localhost:5000/offers/";
	this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public List<Offer> listarOfertas()
    {
            List<Offer> listaProduct=null;			

            WebTarget target = this.objClientePeticiones.target(this.endPoint);

            Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON);

            listaProduct = objPeticion.get(new GenericType<List<Offer>>() {});	

            return listaProduct;
    }
    
    public Offer registrarOferta(Offer objofertaRegistar)
    {
            
            Offer  objOferta=null;

            WebTarget target = this.objClientePeticiones.target(this.endPoint);	    

        Entity<Offer> data = Entity.entity(objofertaRegistar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
        
        objOferta = objPeticion.post(data, Offer.class);
        System.out.println("llega");
        return objOferta;
    }
}
