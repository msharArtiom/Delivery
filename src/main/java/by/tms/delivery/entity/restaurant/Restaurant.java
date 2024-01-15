package by.tms.delivery.entity.restaurant;

import by.tms.delivery.entity.address.Address;
import by.tms.delivery.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "tb_restaurant")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "address", nullable = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Address> address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<MenuItem> itemList;
}
