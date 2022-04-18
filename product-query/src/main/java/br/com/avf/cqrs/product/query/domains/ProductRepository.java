package br.com.avf.cqrs.product.query.domains;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
