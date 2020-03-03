package com.oodlefinance.okwu.richard.external.interfaces;

import java.util.List;

import com.oodlefinance.okwu.richard.external.domain.dto.KeyWrapper;
import com.oodlefinance.okwu.richard.external.domain.dto.OdleBuyer;
/**
 * Interface for proxy
 * @author Richard Okwu
 *
 */
public interface InternalProxyInterface
{
   public OdleBuyer getBuyer(String id); 
   
   public List<OdleBuyer> getBuyers(); 
   
   public KeyWrapper addBuyer(OdleBuyer buyer); 
   
   public Boolean deleteBuyer(String id); 
   
   
}
