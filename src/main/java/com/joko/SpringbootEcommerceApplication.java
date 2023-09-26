package com.joko;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.joko.service.ProductService;

@SpringBootApplication
public class SpringbootEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEcommerceApplication.class, args);
	}
	
/*	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
	        productService.save();
	        // more products
		}
	}*/
}
