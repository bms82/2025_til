package per.msb.til.lessons.jan.wk4.projections.dto;

import java.util.List;

class UserOrderDTO {
    private String firstName;
    private String email;
    private List<OrderDTO> orders;

    public UserOrderDTO(String firstName, String email, List<OrderDTO> orders) {
        this.firstName = firstName;
        this.email = email;
        this.orders = orders;
    }
    // Getters and setters
}