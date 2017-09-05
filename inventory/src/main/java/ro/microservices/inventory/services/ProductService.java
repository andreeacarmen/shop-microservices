package ro.microservices.inventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.microservices.inventory.configs.KafkaGateway;
import ro.microservices.inventory.entities.Product;
import ro.microservices.inventory.mappers.ProductMapper;
import ro.microservices.inventory.models.ProductModel;
import ro.microservices.inventory.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final KafkaGateway kafkaGateway;	
	
	@Autowired
	public ProductService(ProductRepository productRepository, KafkaGateway kafkaGateway) {
		this.productRepository = productRepository;
		this.kafkaGateway = kafkaGateway;
	}
	
	public ProductModel save(ProductModel productModel) {
		Product prod = productRepository.findByCode(productModel.getCode()).stream()
			.findFirst()
			.map(p -> {
				p.setPrice(productModel.getPrice());
				
				Integer initStock = p.getStock();
				
				if(initStock != productModel.getStock()) {
					p.setStock(productModel.getStock());
					
					if (initStock == 0 || productModel.getStock() == 0) {
						kafkaGateway.write(productModel);
					}
				}
				
				return p;
			})
			.orElseGet(() -> ProductMapper.toEntity(productModel));
		
		
		return ProductMapper.toModel(productRepository.save(prod));
	}
	
	
}
