package by.tms.delivery.entity.user;

import by.tms.delivery.entity.address.Address;
import by.tms.delivery.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Set<Address> address;

}
