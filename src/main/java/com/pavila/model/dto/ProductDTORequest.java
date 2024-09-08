package com.pavila.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTORequest {

    @NotBlank(message = "The name field cannot be blank.")
    private String name;
    @NotNull(message = "Price cannot be null.")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0.")
    private BigDecimal price;
    @NotNull(message = "The availability status must not be null")
    private boolean available;
}
