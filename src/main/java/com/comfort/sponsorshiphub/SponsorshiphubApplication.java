package com.comfort.sponsorshiphub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.comfort.sponsorshiphub.component.ComponentMobile;
import com.comfort.sponsorshiphub.component.ComponentUtil;
import com.comfort.sponsorshiphub.controller.SponsorController;
import com.comfort.sponsorshiphub.controller.SponsorController2;

@SpringBootApplication
public class SponsorshiphubApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext ctx = SpringApplication.run(SponsorshiphubApplication.class, args);
		 SponsorController controller = (SponsorController)ctx.getBean("sponsorController");
		 System.out.println(controller.sayHello());
		 
		 SponsorController2 controller2= (SponsorController2)ctx.getBean("sponsorController2");
		 System.out.println(controller2.sayHello());
		 
		
		 
		
		 
	}

}