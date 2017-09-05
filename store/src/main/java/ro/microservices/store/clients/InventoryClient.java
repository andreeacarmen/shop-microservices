package ro.microservices.store.clients;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import ro.microservices.store.models.InventoryModel;

@FeignClient(name = "inventory-service", fallbackFactory = InventoryFallback.class)
public interface InventoryClient {

	@RequestMapping(value = "v1/products/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> getProductInventory(@PathVariable("code") @NotNull final String code);
}
