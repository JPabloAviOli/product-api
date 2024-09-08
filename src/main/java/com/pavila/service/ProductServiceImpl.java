package com.pavila.service;

import com.pavila.exception.ObjectNotFoundException;
import com.pavila.model.dto.ProductDTORequest;
import com.pavila.model.dto.ProductDTOResponse;
import com.pavila.model.entity.Product;
import com.pavila.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public  List<ProductDTOResponse> findAll() {
        log.info("Initiating find all products operation");
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            log.warn("No products found in the repository");
            throw new ObjectNotFoundException("The product list is empty");
        }
        log.info("Found {} products", products.size());
        return products.stream()
                .map(product -> ProductDTOResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .available(product.isAvailable())
                        .createdDate(product.getCreatedDate())
                        .lastModifiedDate(product.getLastModifiedDate())
                        .build()).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTOResponse findById(Long productId) {
        log.info("Attempting to find product with ID: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow( () -> new ObjectNotFoundException("Product not found by id " + productId));
        log.info("Product found: ID = {}, Name = {}", product.getId(), product.getName());
        log.info("Returning product response for ID: {}", productId);
        return ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .available(product.isAvailable())
                .createdDate(product.getCreatedDate())
                .lastModifiedDate(product.getLastModifiedDate())
                .build();
    }

    @Override
    @Transactional
    public ProductDTOResponse save(ProductDTORequest productRequest) {
        log.info("Starting save operation for product with name: {}", productRequest.getName());
        Product product = productRepository.save(Product.builder()
                        .name(productRequest.getName())
                        .price(productRequest.getPrice())
                .build());
        log.info("Saving product to the repository");

        log.info("Product saved with ID: {}", product.getId());
        return ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .available(product.isAvailable())
                .createdDate(product.getCreatedDate())
                .lastModifiedDate(product.getLastModifiedDate())
                .build();
    }

    @Override
    @Transactional
    public void update(ProductDTORequest productDTORequest, Long productId) {
        log.info("Starting update operation for product with ID: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow( () -> new ObjectNotFoundException("Product not found by id " + productId));
        log.info("Product found: {}", product);
        BeanUtils.copyProperties(productDTORequest, product);
        log.info("Saving updated product to the repository");
        Product updatedProduct = productRepository.save(product);
        log.info("Product updated successfully with ID: {}", updatedProduct.getId());

    }

    @Override
    @Transactional
    public void delete(Long productId) {
        log.info("Starting delete operation for product with ID: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow( () -> new ObjectNotFoundException("Product not found by id " + productId));
        log.info("Deleting product with ID: {}", productId);
        productRepository.delete(product);
        log.info("Product with ID: {} has been successfully deleted", productId);
    }

    @Override
    @Transactional
    public void updateAvailableProduct(Long productId) {
        log.info("Starting update of product availability for product with ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("Product not found by id " + productId));

        boolean newAvailability = !product.isAvailable();
        log.info("Updating product availability to: {}", newAvailability);
        product.setAvailable(newAvailability);

        log.info("Saving updated product with ID: {}", productId);
        productRepository.save(product);
        log.info("Product availability updated successfully for ID: {}", productId);
    }
}
