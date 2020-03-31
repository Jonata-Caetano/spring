package com.tr.pluralsight;

import com.tr.pluralsight.service.CustomerService;
import com.tr.pluralsight.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//        CustomerServiceImpl customerService = new CustomerServiceImpl();
        CustomerService service = applicationContext.getBean("customerService", CustomerService.class);

        System.out.println(service);

        CustomerService service2 = applicationContext.getBean("customerService", CustomerService.class);

        System.out.println(service2);

        System.out.println(service.findAll().get(0).getFirstName());
    }
}
