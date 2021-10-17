
package com.tr.pluralsight;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.tr.pluralsight"})
@PropertySource("application.properties")
public class AppConfig {

/*    @Bean(name = "customerService")
    public CustomerService getCustomerService() {
        CustomerServiceImpl customerService = new CustomerServiceImpl(*//*getCustomerRepository()*//**//*injection by constructor*//*);
//        customerService.setCustomerRepository(getCustomerRepository());//injection by setter
        return customerService;
    }*/

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}