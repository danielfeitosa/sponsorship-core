package com.comfort.sponsorshiphub.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.comfort.sponsorshiphub.controller.SponsorController;
@Component
public class SpringContext implements ApplicationContextAware,ServletContextAware,ServletConfigAware,BeanNameAware{

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext");
		System.out.println(((SponsorController)applicationContext.getBean("sponsorController")).sayHello());
		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		System.out.println("setServletContext");
		
		
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		System.out.println("setServletConfig");
		
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName");
		System.out.println(name);
		
	}

}
