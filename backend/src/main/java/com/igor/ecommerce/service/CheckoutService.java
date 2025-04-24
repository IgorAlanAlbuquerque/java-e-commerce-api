package com.igor.ecommerce.service;

import com.igor.ecommerce.dto.Purchase;
import com.igor.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}