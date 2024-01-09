package by.tms.delivery.entity.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_address")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "home_number", nullable = false)
    private String homeNumber;

    @Column(name = "flat_number")
    private String flatNumber;

}
