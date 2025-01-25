package per.msb.til.lessons.jan.wk4.projections.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new UserOrderDTO(u.firstName, u.email, " +
            "new OrderDTO(o.product, o.price)) " +
            "FROM User u LEFT JOIN u.orders o")
    List<UserOrderDTO> findUserOrderDTOs();

    @Query(value = "SELECT u.first_name as firstName, u.email as email, " +
            "o.product as product, o.price as price " +
            "FROM user u " +
            "LEFT JOIN orders o ON u.id = o.user_id", nativeQuery = true)
    List<UserOrderDTO> findUserOrderDTOsNative();
}