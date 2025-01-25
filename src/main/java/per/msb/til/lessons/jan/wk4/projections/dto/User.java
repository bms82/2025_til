package per.msb.til.lessons.jan.wk4.projections.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}
