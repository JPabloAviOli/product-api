package com.pavila.controller;

import com.pavila.model.dto.ApiError;
import com.pavila.model.dto.ProductDTORequest;
import com.pavila.model.dto.ProductDTOResponse;
import com.pavila.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;


    @Operation(
            summary = "Returns all products",
            description = "Get a list of all products",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A list of product objects",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDTOResponse.class, type = "array"),
                                    examples = @ExampleObject(
                                            name = "Products Example",
                                            summary = "Example of a list of products",
                                            value = "[{\"id\": 1, \"name\": \"Product 1\", \"price\": 29.99, \"available\": true, \"createdDate\": \"2024-08-10T12:00:00\", \"lastModifiedDate\": \"2024-08-10T12:00:00\"}, {\"id\": 2, \"name\": \"Product 2\", \"price\": 39.99, \"available\": false, \"createdDate\": \"2024-08-10T12:00:00\", \"lastModifiedDate\": \"2024-08-10T12:00:00\"}]"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No products found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class),
                                    examples = @ExampleObject(
                                            name = "Error Example",
                                            summary = "Example of an error response when no products are found",
                                            value = "{\"http_code\": 404, \"url\": \"/api/v1/products\", \"http_method\": \"GET\", \"message\": \"No products found\", \"backend_message\": \"The request was successful, but there are no products available in the database.\", \"timestamp\": \"10:08:2024 12:00:00\", \"details\": [\"Ensure products are added to the database\", \"Check the database connection\"]}"
                                    )
                            )
                    )
            }
    )
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<List<ProductDTOResponse>> findAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }


    @Operation(
            summary = "Return a product",
            description = "Get a product by ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product retrieved successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDTOResponse.class),
                                    examples = @ExampleObject(
                                            name = "Product Example",
                                            summary = "Example of a product response",
                                            value = "{\"id\": 1, \"name\": \"Sample Product\", \"price\": 199.99, \"available\": true, \"createdDate\": \"2024-08-10T12:00:00\", \"lastModifiedDate\": \"2024-08-10T12:00:00\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class),
                                    examples = @ExampleObject(
                                            name = "Error Example",
                                            summary = "Example of an error response",
                                            value = "{\"message\": \"Product not found by id 1\", \"http_code\": 404, \"timestamp\": \"2024-08-10T12:00:00\"}"
                                    )
                            )
                    )
            }
    )
    @GetMapping( value = "/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<ProductDTOResponse> findProductById(@PathVariable Long productId ){
        return ResponseEntity.ok(productService.findById(productId));
    }



    @Operation(
            summary = "Creates a new product",
            description = "Creates a new product and returns the created product",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The created product",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDTOResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request due to invalid input",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class)
                            )
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTORequest.class),
                            examples = @ExampleObject(
                                    name = "Example Value",
                                    summary = "Example product",
                                    value = "{\n  \"name\": \"MackBook Air\",\n  \"price\": 11000\n}"
                            )
                    )
            )
    )
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<ProductDTOResponse> saveProduct(@RequestBody @Valid ProductDTORequest productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productRequest));
    }



    @Operation(
            summary = "Update available product",
            description = "Updates the availability of a product",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The updated product",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDTOResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request due to invalid input",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class)
                            )
                    )
            }
    )
    @PatchMapping( value = "/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<?> updateAvailableProduct(@PathVariable Long productId ){
        productService.updateAvailableProduct(productId);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = "Update a product",
            description = "Update a product by ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The updated product",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDTOResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request due to invalid input",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class)
                            )
                    )

            }
    )
    @PutMapping( value = "/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<?> updateProduct(@RequestBody @Valid ProductDTORequest productRequest, @PathVariable Long productId ){
        productService.update(productRequest, productId);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = "Delete a product",
            description = "Delete a product by ID",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "The product has been deleted. No Content",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductDTOResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiError.class)
                            )
                    )
            }
    )
    @DeleteMapping(value = "/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<?> deleteProductById(@PathVariable Long productId){
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }

}
