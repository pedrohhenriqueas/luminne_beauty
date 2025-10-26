package org.acme.service;

import java.util.List;
import java.util.Optional;

import org.acme.entities.Product;
import org.acme.models.CreateProductDto;
import org.acme.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Product create(CreateProductDto newProduct){
        Product product = new Product();
        product.setName(newProduct.getName());
        product.setImagePath(newProduct.getPath());
        product.setPrice(newProduct.getPrice());
        product.setDesctiption(newProduct.getDescription());
        product.setReviews(newProduct.getReviews());
        productRepository.save(product);
        return product;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(int productId){
        Optional<Product> product = productRepository.findById(productId);
        return product.get();
    }

    public Product findByName(String name){
        return productRepository.findByName(name);
    }

    public void deleteProduct(int productId){
        productRepository.deleteById(productId);
    }

    public Product update(CreateProductDto productDto){
        Product product = findById(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImagePath(productDto.getPath());
        product.setReviews(productDto.getReviews());
        product.setDesctiption(productDto.getDescription());
        productRepository.save(product);

        return findById(product.getId());
    }
}
