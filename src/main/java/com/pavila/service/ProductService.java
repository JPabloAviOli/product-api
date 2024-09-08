package com.pavila.service;

import com.pavila.model.dto.ProductDTORequest;
import com.pavila.model.dto.ProductDTOResponse;

import java.util.List;

public interface ProductService {

   List<ProductDTOResponse> findAll();
   ProductDTOResponse findById(Long productId);
   ProductDTOResponse save(ProductDTORequest productRequest);
   void update(ProductDTORequest productDTORequest, Long productId);
   void delete(Long productId);
   void updateAvailableProduct(Long productId);

}
