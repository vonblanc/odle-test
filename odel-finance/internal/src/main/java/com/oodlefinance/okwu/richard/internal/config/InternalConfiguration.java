package com.oodlefinance.okwu.richard.internal.config;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
/**
 * Internal config
 * @author Richard Okwu
 *
 */
@Configuration 
public class InternalConfiguration {

   
	
	
	@Scope(InternalConstants.SCOPE_SINGLETON)
	@Bean 
	public ConcurrentHashMap basicStore()
	{
		return new ConcurrentHashMap(); 
	}
	
	
	
	
}
