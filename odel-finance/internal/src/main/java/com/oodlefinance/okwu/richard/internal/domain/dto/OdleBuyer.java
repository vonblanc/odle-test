package com.oodlefinance.okwu.richard.internal.domain.dto;

import java.util.List;
/**
 * Encapsulate customer information 
 * @author Richard Okwu
 *
 */
public class OdleBuyer
{

	
   private String id;
   
   private String name; 
   
   private String address; 
      
   public OdleBuyer(){}
   
   public String getName()
   {
      return name;
   }

   public String getAddress()
   {
      return address;
   }

  
   public void setName(String name)
   {
      this.name = name;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }


   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }
   public String generateKey()
   {
	   String noSpaceName = null,noSpaceAddress = null;
	   
	   if(name != null) noSpaceName =name.replaceAll("\\s","");
	    if(address!= null) noSpaceAddress=address.replaceAll("\\s","");
	    
	    return noSpaceName.concat(noSpaceAddress);
   }
   
   
}
