package ro.microservices.store.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ro.microservices.store.entities.Category;

@Data
@AllArgsConstructor
@Builder
public class ProductModel {

	
	private String code;
	
	@NotNull
	private BigDecimal price;
	
	@NotNull
	private Integer stock;
	
	private Category category;
	
}

