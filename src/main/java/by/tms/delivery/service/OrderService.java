package by.tms.delivery.service;

import by.tms.delivery.entity.order.Order;
import by.tms.delivery.entity.order.OrderItem;
import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.exception.NotFoundException;
import by.tms.delivery.repository.MenuItemRepository;
import by.tms.delivery.repository.OrderItemRepository;
import by.tms.delivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    public Order addMenuItemToOrder(Long orderId, Long menuItemId, int quantity, BigDecimal price) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found!"));

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
}
