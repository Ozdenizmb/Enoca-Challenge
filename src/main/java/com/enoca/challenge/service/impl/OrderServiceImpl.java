package com.enoca.challenge.service.impl;

import com.enoca.challenge.dto.OrderDto;
import com.enoca.challenge.exception.EnocaException;
import com.enoca.challenge.exception.ErrorMessages;
import com.enoca.challenge.mapper.OrderMapper;
import com.enoca.challenge.mapper.PageMapperHelper;
import com.enoca.challenge.model.Cart;
import com.enoca.challenge.model.CartItem;
import com.enoca.challenge.model.Order;
import com.enoca.challenge.model.OrderItem;
import com.enoca.challenge.model.Product;
import com.enoca.challenge.repository.CartRepository;
import com.enoca.challenge.repository.OrderRepository;
import com.enoca.challenge.repository.ProductRepository;
import com.enoca.challenge.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderMapper mapper;

    private void reduceTheStock(UUID productId, int quantity) {
        Optional<Product> responseProduct = productRepository.findById(productId);

        if(responseProduct.isPresent()) {
            Product product = responseProduct.get();
            product.setStock(product.getStock() - quantity);
            productRepository.save(product);
        }
    }

    private void emptyCart(Cart cart) {
        cart.getItems().clear();
        cart.getCustomer().setCart(null);
        cartRepository.delete(cart);
    }

    @Override
    public OrderDto placeOrder(UUID customerId) {
        Optional<Cart> responseCart = cartRepository.findByCustomerId(customerId);

        if(responseCart.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.ORDER_COULD_NOT_PLACE_CART_NOTFOUND);
        }

        Cart cart = responseCart.get();

        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        List<OrderItem> items = new ArrayList<>();
        for(CartItem item : cart.getItems()) {
            if(item.getProduct().getStock() - item.getQuantity() <= 0) {
                String errorMessages = "There is not enough stock available for the requested quantity of the "
                        +item.getProduct().getName()+" product. Please update the items in your cart. Stock: "
                        +item.getProduct().getStock();
                throw EnocaException.withStatusAndMessage(HttpStatus.BAD_REQUEST, errorMessages);
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setOrderProductUnitPrice(item.getProduct().getPrice());
            orderItem.setQuantity(item.getQuantity());
            items.add(orderItem);
        }
        order.setItems(items);
        order.setTotalPrice(cart.getTotalPrice());

        Order saveOrder = repository.save(order);
        for(OrderItem orderItem : order.getItems()) {
            reduceTheStock(orderItem.getProduct().getId(), orderItem.getQuantity());
        }
        emptyCart(cart);

        return mapper.toDto(saveOrder);
    }

    @Override
    public OrderDto getOrderForCode(UUID OrderId) {
        Optional<Order> responseOrder = repository.findById(OrderId);

        if(responseOrder.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ORDER_NOT_FOUND);
        }

        return mapper.toDto(responseOrder.get());
    }

    @Override
    public Page<OrderDto> getAllOrdersForCustomer(UUID customerId, Pageable pageable) {
        Page<Order> orders = repository.findAllByCustomerId(customerId, pageable);

        if(orders.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ORDER_NOT_FOUND);
        }

        return PageMapperHelper.mapEntityPageToDtoPage(orders, mapper);
    }
}
