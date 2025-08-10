package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.Customer;
import com.ecommerce.ecommerce.entity.Order;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.repository.CustomerRepository;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    // Create new order
    public Order createOrder(Long customerId, List<Long> productIds) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (!customerOpt.isPresent()) {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }

        Set<Product> products = new HashSet<>();
        for (Long productId : productIds) {
            Optional<Product> productOpt = productRepository.findById(productId);
            if (productOpt.isPresent()) {
                products.add(productOpt.get());
            } else {
                throw new RuntimeException("Product not found with ID: " + productId);
            }
        }

        Order order = new Order();
        order.setCustomer(customerOpt.get());
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
