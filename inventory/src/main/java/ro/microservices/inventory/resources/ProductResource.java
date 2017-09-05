package ro.microservices.inventory.resources;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.microservices.inventory.mappers.ProductMapper;
import ro.microservices.inventory.models.ProductModel;
import ro.microservices.inventory.repositories.ProductRepository;
import ro.microservices.inventory.services.ProductService;

@RestController
@RequestMapping("v1/products")
public class ProductResource {

	private final ProductRepository productRepository;

	private final ProductService productService;

	@Autowired
	public ProductResource(final ProductRepository productRepository,final ProductService productService) {
		this.productRepository = Objects.requireNonNull(productRepository, "product repo should not be null");
		this.productService = Objects.requireNonNull(productService, "product service should not be null");

	}
	
	@GetMapping(value = "/{code}")
	public ResponseEntity<ProductModel> getProductsByCode(@PathVariable("code") final String code) {
		return productRepository.findByCode(code).stream()
				.findFirst()
				.map(e -> {
					return ResponseEntity.ok(ProductMapper.toModel(e));
				})
				.orElseGet(()-> new ResponseEntity<ProductModel>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<ProductModel> save(@RequestBody final ProductModel productModel) {
		return ResponseEntity.ok(productService.save(productModel));
	}
}
