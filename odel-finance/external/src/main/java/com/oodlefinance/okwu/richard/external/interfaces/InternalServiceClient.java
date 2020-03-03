package com.oodlefinance.okwu.richard.external.interfaces;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oodlefinance.okwu.richard.external.domain.dto.KeyWrapper;
import com.oodlefinance.okwu.richard.external.domain.dto.OdleBuyer;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
/**
 * Feign Client Definition
 * @author Richard Okwu
 *
 */
@FeignClient(name ="external")
public interface InternalServiceClient
{

	@GetMapping(value = "/buyers/{id}")
   public OdleBuyer getBuyer(@PathVariable("id") String id); //@Param
   
   @GetMapping( value = "/buyers")
   public List<OdleBuyer> getAllBuyers(); 
   
    @PostMapping( value = "/addBuyer", consumes = "application/json")
   public KeyWrapper addBuyer(OdleBuyer buyer);
   
   @DeleteMapping( value = "/buyers/{id}") 
   public Boolean deleteBuyer(@PathVariable ("id") String id); 
  
   @RequestMapping(method = RequestMethod.GET, value = "/ping")
   public OdleBuyer ping();
   
   
   
   
   

   
}
