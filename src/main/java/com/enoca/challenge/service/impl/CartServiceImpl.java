package com.enoca.challenge.service.impl;

import com.enoca.challenge.dto.AddProductDto;
import com.enoca.challenge.dto.CartDto;
import com.enoca.challenge.dto.RemoveProductDto;
import com.enoca.challenge.exception.EnocaException;
import com.enoca.challenge.exception.ErrorMessages;
import com.enoca.challenge.mapper.CartMapper;
import com.enoca.challenge.model.Cart;
import com.enoca.challenge.model.CartItem;
import com.enoca.challenge.model.Customer;
import com.enoca.challenge.model.Product;
import com.enoca.challenge.repository.CartRepository;
import com.enoca.challenge.repository.CustomerRepository;
import com.enoca.challenge.repository.ProductRepository;
import com.enoca.challenge.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository repository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartMapper mapper;

    @Override
    public CartDto getCart(UUID customerId) {
        Optional<Cart> responseCart = repository.findByCustomerId(customerId);

        if(responseCart.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.CART_NOT_FOUND);
        }

        return mapper.toDto(responseCart.get());
    }

    private Cart addProduct(Cart cart, AddProductDto addProductDto) {
        Optional<Product> responseProduct = productRepository.findById(addProductDto.productId());

        if(responseProduct.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        Product product = responseProduct.get();

        // Check if the product already exists in the cart
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        if(existingItem.isPresent()) {
            CartItem cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + addProductDto.quantity());
        }
        else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(addProductDto.quantity());
            cart.getItems().add(cartItem);
        }

        double totalPrice = cart.getItems().stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
        cart.setTotalPrice(totalPrice);

        return repository.save(cart);
    }

    @Override
    public CartDto AddProductToCart(UUID customerId, AddProductDto addProductDto) {
        Optional<Cart> responseCart = repository.findByCustomerId(customerId);

        if(responseCart.isEmpty()) {
            Optional<Customer> responseCustomer = customerRepository.findById(customerId);

            if(responseCustomer.isEmpty()) {
                throw EnocaException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.CUSTOMER_NOT_FOUND);
            }

            Customer customer = responseCustomer.get();
            Cart cart = new Cart();

            cart.setCustomer(customer);
            customer.setCart(cart);

            cart = addProduct(cart, addProductDto);
            customerRepository.save(customer);
            return mapper.toDto(cart);
        }
        else {
            Cart cart = responseCart.get();
            cart = addProduct(cart, addProductDto);
            return mapper.toDto(cart);
        }
    }

    @Override
    public CartDto RemoveProductFromCart(UUID customerId, RemoveProductDto removeProductDto) {
        return null;
    }

}
