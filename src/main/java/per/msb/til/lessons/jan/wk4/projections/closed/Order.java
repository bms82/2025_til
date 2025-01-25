package per.msb.til.lessons.jan.wk4.projections.closed;

import jakarta.persistence.*;

@Entity
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Getters and setters
}
