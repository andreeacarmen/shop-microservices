package ro.microservices.inventory.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class ProductModel {

	
private String code;
	
	@NotNull
	private BigDecimal price;
	
	@NotNull
	private Integer stock;
}
