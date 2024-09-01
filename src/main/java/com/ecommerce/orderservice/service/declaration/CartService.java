package com.ecommerce.orderservice.service.declaration;

import com.ecommerce.orderservice.dto.CartRequest;
import com.ecommerce.orderservice.dto.CartResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface CartService {
    CartResponse addToCartLoggedInUser(CartRequest cartRequest, String browserSessionId);

    CartResponse addToCartGuestUser(CartRequest cartRequest, String browserSessionId);

    CartResponse getCartItems(String deviceId, HttpServletRequest request);

    Object removeItemFromCart(String deviceId, String skuId);

    Object updateItemQuantity(String deviceId, CartRequest cartRequest);


}
