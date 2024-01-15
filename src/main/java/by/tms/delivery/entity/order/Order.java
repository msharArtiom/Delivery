package by.tms.delivery.entity.order;

import by.tms.delivery.entity.enums.Status;
import by.tms.delivery.entity.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany
    @JoinColumn(name = "order_item", referencedColumnName = "id")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Set<Status> status;

    @Column(name = "full_price")
    private BigDecimal fullPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime localDateTime;

}
