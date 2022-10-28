package projet.wcs.starter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}