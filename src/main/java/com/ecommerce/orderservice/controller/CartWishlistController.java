package com.ecommerce.orderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Tag(name = "Cart & Wishlist Controller",description = "REST APIs for Adding Products to Cart & Wishlist.")
public class CartWishlistController {

    @Operation(summary = "Authenticated index API")
    @GetMapping("/index")
    public String index(){
        return "From Order Service";
    }
}
