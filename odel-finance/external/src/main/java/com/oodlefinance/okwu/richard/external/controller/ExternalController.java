package com.oodlefinance.okwu.richard.external.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oodlefinance.okwu.richard.external.domain.dto.KeyWrapper;
import com.oodlefinance.okwu.richard.external.domain.dto.OdleBuyer;
import com.oodlefinance.okwu.richard.external.service.InternalProxyService;
import org.springframework.http.MediaType;

/**
 * External controller
 * @author Richard Okwu
 *
 */
@Controller
public class ExternalController
{
   
   @Autowired 
   InternalProxyService internalProxyService;
   
   /**
    * Fetch buyers return list of OdleBuyer
    * @return List<OdleBuyer>
    */
   @GetMapping("/buyers")
   @ResponseBody 
   public List<OdleBuyer> buyer()
   {
      return internalProxyService.getBuyers();
   }
   /**
    * Fetch buyer return OdleBuyer
    * @param id
    * @return OdleBuyer
    */
   @GetMapping("/buyers/{id}")
   @ResponseBody
   public OdleBuyer fetchBuyer(@PathVariable String id)
   
   {
	   return internalProxyService.getBuyer(id);
   }
   
   
   /**
    * Add buyer return id
    * @param buyer
    * @return String
    */
   @PostMapping(value="/addBuyer",consumes = "application/json", produces = "application/json")
   @ResponseBody
   public KeyWrapper addBuyer(@RequestBody OdleBuyer buyer)
   {
      
      return  internalProxyService.addBuyer(buyer);
      
   }
   /**
    * Delete buyer return boolean object
    * @param id
    * @return Boolean
    */
   @DeleteMapping("/buyers/{id}")
   public @ResponseBody Boolean deleteBuyer(@PathVariable String id)
   {
      return internalProxyService.deleteBuyer(id);
   }
   
   
   /**
    * Ping internal for sanity check
    * @return OdleBuyer
    */
   @GetMapping("/ping")
   public @ResponseBody OdleBuyer ping()
   {
	   return internalProxyService.ping();
      
   }

}
