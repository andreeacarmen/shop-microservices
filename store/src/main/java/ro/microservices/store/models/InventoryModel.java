package ro.microservices.store.models;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.microservices.store.entities.Category;
import ro.microservices.store.entities.Product;
import ro.microservices.store.entities.Product.ProductBuilder;

@Data
@AllArgsConstructor
@Builder
public class InventoryModel {

	private String code;
	private BigDecimal price;
	private Integer stock;
	
}
