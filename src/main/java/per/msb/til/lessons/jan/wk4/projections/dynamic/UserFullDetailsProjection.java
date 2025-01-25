package per.msb.til.lessons.jan.wk4.projections.dynamic;

import java.util.List;

public interface UserFullDetailsProjection {
    String getFirstName();
    String getLastName();
    String getEmail();
    List<OrderDTO> getOrders();
}