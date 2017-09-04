package ro.microservices.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;

import ro.microservices.store.entities.Category;
import ro.microservices.store.entities.Product;
import ro.microservices.store.repository.CategoryRepository;
import ro.microservices.store.repository.ProductRepository;

@SpringBootApplication
@EnableEurekaClient
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@Component
	class DummyData implements CommandLineRunner {

		@Autowired
		private CategoryRepository categoryRepository;
		
		@Autowired
		private ProductRepository productRepository;
		
		@Override
		public void run(String... arg0) throws Exception {
			
			Category categ = categoryRepository.save(Category.builder().name("test categ").build());
			
			productRepository.save(Product.builder().code("prod3").category(categ).build());
			
		}
		
	}
	
}
