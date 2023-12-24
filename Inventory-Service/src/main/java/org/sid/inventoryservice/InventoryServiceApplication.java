package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository
	, RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args -> {
			productRepository.save(new Product(null, "Ordinateur", 20000.00, 10));
			productRepository.save(new Product(null, "Calucatrice", 140.50, 10));
			productRepository.save(new Product(null, "PC", 14000.50, 220));
			productRepository.save(new Product(null, "phone", 20000, 33));
			productRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}
