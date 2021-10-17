package com.tr.pluralsight;

import com.tr.pluralsight.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerService service = context.getBean("customerService", CustomerService.class);

        System.out.println(service.findAll().get(0).getFirstName());

        ((ClassPathXmlApplicationContext) context).close();
        
    }
}
