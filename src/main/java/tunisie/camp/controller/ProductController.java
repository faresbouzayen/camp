package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Product;
import tunisie.camp.dto.ProductDTO;
import tunisie.camp.service.ProductService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductService product_service;
    private final ModelMapper not_mapper;

    private ProductDTO toDto(Product product){
        return not_mapper.map(product, ProductDTO.class);
    }
    private Product toEntity(ProductDTO productDTO){
        return not_mapper.map(productDTO, Product.class);
    }

    @GetMapping
    public List<ProductDTO> getProducts(){
        var product_list = StreamSupport
                .stream(product_service.findAllProducts().spliterator(), false)
                .collect(Collectors.toList());
        return product_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductDTO postProduct(@Validated @RequestBody ProductDTO product_dto){
        var entity = toEntity(product_dto);
        var product = product_service.addProduct(entity);
        return toDto(product);
    }

    @PutMapping("/{id}")
    public void putProduct(@PathVariable("id") UUID id, @Validated @RequestBody ProductDTO product_dto){
        var product_domain = toEntity(product_dto);
        product_service.updateProduct(id,product_domain);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") UUID id){
        product_service.removeProduct(id);
    }
}
