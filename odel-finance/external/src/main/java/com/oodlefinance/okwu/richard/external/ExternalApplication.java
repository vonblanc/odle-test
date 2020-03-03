package com.oodlefinance.okwu.richard.external;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
 @EnableFeignClients("external")
//@RibbonClient(name = "external", configuration = RibbonConfiguration.class)
public class ExternalApplication {


   
   
	public static void main(String[] args) {
		SpringApplication.run(ExternalApplication.class, args);
				
		
	}

}
