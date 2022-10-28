package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}