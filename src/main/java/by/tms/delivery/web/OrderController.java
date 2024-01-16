package by.tms.delivery.web;

import by.tms.delivery.entity.order.Order;
import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.entity.restaurant.Restaurant;
import by.tms.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Order> addMenuItemToOrder(@PathVariable Long orderId,
                                                    @RequestBody Order order,
                                                    @RequestParam Long menuItemId,
                                                    @RequestParam int quantity,
                                                    @RequestParam BigDecimal price) {
        orderService.addMenuItemToOrder(order, orderId, menuItemId, quantity, price);

        BigDecimal fullPrice = order.getOrderItemList().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setFullPrice(fullPrice);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity<Order> deleteOrderItem(@RequestBody Order order,
                                                 @RequestBody MenuItem menuItem) {

        orderService.deleteMenuItemToOrder(order, menuItem);
        BigDecimal fullPrice = order.getOrderItemList().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setFullPrice(fullPrice);
        return ResponseEntity.ok().build();
    }
}
