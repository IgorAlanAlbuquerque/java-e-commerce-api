package com.igor.ecommerce.service;
 
 import org.springframework.stereotype.Service;
 
 import com.igor.ecommerce.repository.CustomerRepository;
 import com.igor.ecommerce.dto.Purchase;
 import com.igor.ecommerce.dto.PurchaseResponse;
 import com.igor.ecommerce.entity.Customer;
 import com.igor.ecommerce.entity.Order;
 import com.igor.ecommerce.entity.OrderItem;
 
 import javax.transaction.Transactional;
 import java.util.Set;
 import java.util.UUID;
 
 @Service
 public class CheckoutServiceImpl implements CheckoutService {
 
     private CustomerRepository customerRepository;
 
     public CheckoutServiceImpl(CustomerRepository customerRepository) {
         this.customerRepository = customerRepository;
     }
 
     @Override
     @Transactional
     public PurchaseResponse placeOrder(Purchase purchase) {
 
         // retrieve the order info from dto
         Order order = purchase.getOrder();
 
         // generate tracking number
         String orderTrackingNumber = generateOrderTrackingNumber();
         order.setOrderTrackingNumber(orderTrackingNumber);
 
         // populate order with orderItems
         Set<OrderItem> orderItems = purchase.getOrderItems();
         orderItems.forEach(item -> order.add(item));
 
         // populate order with billingAddress and shippingAddress
         order.setBillingAddress(purchase.getBillingAddress());
         order.setShippingAddress(purchase.getShippingAddress());
 
         // populate customer with order
         Customer customer = purchase.getCustomer();
         customer.add(order);
 
         // save to the database
         customerRepository.save(customer);
 
         // return a response
         return new PurchaseResponse(orderTrackingNumber);
     }
 
     private String generateOrderTrackingNumber() {
 
         return UUID.randomUUID().toString();
     }
 }
 
 
 