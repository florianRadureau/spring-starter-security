package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Product;
import projet.wcs.starter.dto.ProductDto;
import projet.wcs.starter.repositories.ProductRepository;
import projet.wcs.starter.services.UserDetailsImpl;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(allowedHeaders = { "Authorization", "Origin"})
public class ProductController {

    @Autowired private ProductRepository repo;

    @Autowired private ModelMapper modelMapper;

    @PostMapping
    public ProductDto create(@RequestBody @Valid ProductDto product) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        product.setOwnerId(userDetails.getId());

        Product savedProduct = repo.save(modelMapper.map(product, Product.class));
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @GetMapping
    public List<ProductDto> list() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repo.findAllByOwnerId(userDetails.getId())
                .stream()
                .map(p -> modelMapper.map(p, ProductDto.class))
                .toList();
    }
}
