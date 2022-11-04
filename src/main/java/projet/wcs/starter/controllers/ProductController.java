package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Product;
import projet.wcs.starter.repositories.ProductRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(allowedHeaders = { "Authorization", "Origin"})
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
