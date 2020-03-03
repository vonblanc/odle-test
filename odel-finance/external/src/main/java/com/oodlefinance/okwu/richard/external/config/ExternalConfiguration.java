package com.oodlefinance.okwu.richard.external.config;

import java.net.URI;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.oodlefinance.okwu.richard.external.ExternalConstants;
import com.oodlefinance.okwu.richard.external.interfaces.InternalServiceClient;


import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
/**
 * 
 * @author Richard Okwu
 *
 */
@Configuration
public class ExternalConfiguration {

   @Value("${internal.app.name}")
   private String internalAppName;
   
   @Bean 
   @Scope(value=ExternalConstants.SCOPE_PROTOTYPE)
   @Lazy
   public URI internalUri(DiscoveryClient discoveryClient) throws ServiceUnavailableException
   {
      
      Optional<URI> isUri = discoveryClient.getInstances(internalAppName).stream().
      map(instance->instance.getUri()).findFirst();
      
      if(isUri.isPresent()) 
      {
    	  
    	  	  String pathWithContext= isUri.get().getPath()+"/"+internalAppName;
    	  	  
          return isUri.get().resolve(pathWithContext); 
      }
      
      else {
         
         throw new ServiceUnavailableException();
      }
   }
   
   
   /**
    * Feign Client to make calls to internal node 
    * @param internalUri
    * @return BuyerClient
    */
   @Bean 
   @Scope(value=ExternalConstants.SCOPE_PROTOTYPE)
   @Lazy
   public InternalServiceClient buyerClient(URI internalUri)
   {
      InternalServiceClient buyerClient = Feign.builder()
    		  .contract(new SpringMvcContract())
    		  .encoder(new JacksonEncoder())
    		  .decoder(new JacksonDecoder())
           .target(InternalServiceClient.class, internalUri.toString());
      
      return buyerClient;
   }
	
   
 
}
