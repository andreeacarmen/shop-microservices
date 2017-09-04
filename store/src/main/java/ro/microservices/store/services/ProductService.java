package ro.microservices.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.microservices.store.clients.InventoryClient;
import ro.microservices.store.entities.Product;
import ro.microservices.store.mappers.ProductMapper;
import ro.microservices.store.models.InventoryModel;
import ro.microservices.store.models.ProductModel;
import ro.microservices.store.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final InventoryClient inventoryClient;
	
	@Autowired
	public ProductService(final ProductRepository productRepository, final InventoryClient inventoryClient) {
		this.productRepository = productRepository;
		this.inventoryClient = inventoryClient;
	}
	
	public Optional<ProductModel> getByCode (final String code) {
		return productRepository.findByCode(code).stream()
				.findFirst()
				.map(this::productToProductModel);
	}
	
	private ProductModel productToProductModel(final Product product) {
		InventoryModel productInv = inventoryClient.getProductInventory(product.getCode());
		
		return ProductMapper.toModel(product, productInv);
		
	}
}
