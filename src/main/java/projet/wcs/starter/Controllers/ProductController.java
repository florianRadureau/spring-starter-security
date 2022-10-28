package projet.wcs.starter.Controllers;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.Entities.Product;
import projet.wcs.starter.Repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired private ProductRepository repo;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Product product) {
        Product savedProduct = repo.save(product);
        URI productURI = URI.create("/products/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }

    @GetMapping
    public List<Product> list() {
        return repo.findAll();
    }
}
