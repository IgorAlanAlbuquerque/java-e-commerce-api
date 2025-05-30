package com.igor.ecommerce.dto;
 
 import lombok.Data;
 
 import java.util.Set;
 
 import com.igor.ecommerce.entity.Address;
 import com.igor.ecommerce.entity.Customer;
 import com.igor.ecommerce.entity.Order;
 import com.igor.ecommerce.entity.OrderItem;
 
 @Data
 public class Purchase {
 
     private Customer customer;
     private Address shippingAddress;
     private Address billingAddress;
     private Order order;
     private Set<OrderItem> orderItems;
 
 }