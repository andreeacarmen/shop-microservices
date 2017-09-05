package ro.microservices.inventory.mappers;

import ro.microservices.inventory.entities.Product;
import ro.microservices.inventory.models.ProductModel;

public final class ProductMapper {

	public static ProductModel toModel(final Product product) {
		return ProductModel.builder().code(product.getCode())
				.price(product.getPrice())
				.stock(product.getStock())
				.build();
	}

	public static Product toEntity(ProductModel productModel) {
		
		return Product.builder()
				.code(productModel.getCode())
				.stock(productModel.getStock())
				.price(productModel.getPrice())
				.build();
	}
}
