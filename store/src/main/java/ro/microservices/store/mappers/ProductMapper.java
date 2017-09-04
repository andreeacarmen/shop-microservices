package ro.microservices.store.mappers;

import ro.microservices.store.entities.Product;
import ro.microservices.store.models.InventoryModel;
import ro.microservices.store.models.ProductModel;

public final class ProductMapper {

	public static ProductModel toModel(final Product product, final InventoryModel inventory) {
		return ProductModel.builder().code(product.getCode())
				.category(product.getCategory())
				.price(inventory.getPrice())
				.stock(inventory.getStock())
				.build();
	}
}

