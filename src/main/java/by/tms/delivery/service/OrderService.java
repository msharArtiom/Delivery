package by.tms.delivery.service;

import by.tms.delivery.entity.enums.Status;
import by.tms.delivery.entity.order.Order;
import by.tms.delivery.entity.order.OrderItem;
import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.entity.user.User;
import by.tms.delivery.exception.NotFoundException;
import by.tms.delivery.repository.MenuItemRepository;
import by.tms.delivery.repository.OrderItemRepository;
import by.tms.delivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;


    public Order createOrder(Order order){
        order.setLocalDateTime(LocalDateTime.now());
        return orderRepository.save(order);
    }


    public Order addMenuItemToOrder(Order order, Long orderId, Long menuItemId, int quantity, BigDecimal price) {

        if(orderRepository.findById(orderId).isEmpty()) {
            createOrder(order);
        }

        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new NotFoundException("MenuItem not found!"));

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .menuItem(menuItem)
                .quantity(quantity)
                .price(price)
                .build();

        orderItem = orderItemRepository.save(orderItem);

        order.getOrderItemList().add(orderItem);
        return orderRepository.save(order);
    }

    public Order deleteMenuItemToOrder(Order order, MenuItem menuItem) {

        order.getOrderItemList().remove(menuItemRepository.findById(menuItem.getId()));

        return orderRepository.save(order);
    }
}
