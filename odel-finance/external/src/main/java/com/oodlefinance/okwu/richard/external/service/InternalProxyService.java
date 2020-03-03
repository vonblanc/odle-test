package com.oodlefinance.okwu.richard.external.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.oodlefinance.okwu.richard.external.domain.dto.KeyWrapper;
import com.oodlefinance.okwu.richard.external.domain.dto.OdleBuyer;
import com.oodlefinance.okwu.richard.external.interfaces.InternalServiceClient;
import com.oodlefinance.okwu.richard.external.interfaces.InternalProxyInterface;
/**
 * Service to make calls to the Internal node
 * @author Richard Okwu
 *
 */
@Service
public class InternalProxyService implements InternalProxyInterface {

   @Autowired
   @Lazy
   public ObjectFactory<InternalServiceClient> internalServiceClientFactory;
   
   
   /**
    * get buyer
    */
   @Override
   public OdleBuyer getBuyer(String id)
   {      

      return internalServiceClientFactory.getObject().getBuyer(id);
   }


   /**
    * get buyers
    */
   @Override
   public List<OdleBuyer> getBuyers()
   {
      return internalServiceClientFactory.getObject().getAllBuyers();
   }


   /**
    * Add buyer
    */
   @Override
   public KeyWrapper addBuyer(OdleBuyer buyer)
   {
	   return internalServiceClientFactory.getObject().addBuyer(buyer);
	
   }


   /**
    * delete buyer
    */
   @Override
   public Boolean deleteBuyer(String id)
   {
      return internalServiceClientFactory.getObject().deleteBuyer(id);
   }
   
   
   /**
    * ping for data 
    * @return OdleBuyer
    */
   public OdleBuyer ping()
   {
	   return internalServiceClientFactory.getObject().ping();
	   
   }
   
   

   
   
   
   
}
