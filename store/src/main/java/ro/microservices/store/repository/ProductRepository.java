package ro.microservices.store.repository;


import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import ro.microservices.store.entities.Product;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	@RestResource(path = "by-code")
	Collection<Product> findByCode(@Param("code") final String code);

}
