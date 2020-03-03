package com.oodlefinance.okwu.richard.internal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oodlefinance.okwu.richard.internal.domain.dto.KeyWrapper;
import com.oodlefinance.okwu.richard.internal.domain.dto.OdleBuyer;

/**
 * Internal controller
 * @author Richard Okwu
 *
 */
@Controller
public class InternalController
{
   @Autowired 
   private ConcurrentHashMap<String, Object> basicStore;
   
   
   
   @GetMapping("/buyers/{id}")
   @ResponseBody
   public OdleBuyer retriveBuyer(@PathVariable String id)
   {		
	   OdleBuyer buyer= null;
	   
	   if (basicStore.get(id) != null)
	   {
		   buyer= (OdleBuyer) basicStore.get(id);
	   }
	   
	   return buyer;
   }
   
   
   @GetMapping("/buyers")
   @ResponseBody
   public List<OdleBuyer> retriveBuyer()
   {		
	   OdleBuyer buyer= null;
	   
	  List <OdleBuyer>buyerList =new ArrayList(basicStore.values());
	   
	   return buyerList;
   }
   
   @PostMapping(value="/addBuyer",consumes = "application/json", produces = "application/json")
   @ResponseBody
   public synchronized KeyWrapper addBuyer(@RequestBody OdleBuyer buyer)
   {
	   
	   if(buyer == null) 
		{
		   return null;
		}
	   
	   else if(buyer.getId() != null)
	   {
		   basicStore.put(buyer.getId(), buyer);
	   }
	   else if(buyer.getId() == null)
	   {
		   String id= UUID.randomUUID().toString();
		   buyer.setId(id);
		   basicStore.put(id, buyer);
		   
	   }
	   KeyWrapper keyWrapper=new KeyWrapper();
	   keyWrapper.setKey(buyer.getId());
	 
	   return keyWrapper;
	   
   }
   @DeleteMapping("/buyers/{id}")
   @ResponseBody 
   public synchronized Boolean  deleteBuyer(@PathVariable String id )
   {
	   Object previousValue =basicStore.remove(id);
	   
	  return true; 
	   
   }
   
   @GetMapping("/ping")
   @ResponseBody
   public OdleBuyer ping()
   {
	   
	   OdleBuyer odleBye= new OdleBuyer();
	   odleBye.setName("Richard Pong");
      return odleBye;
   }
   
   
   
   
   

}
