package per.msb.til.lessons.jan.wk4.projections.closed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.firstName as firstName, u.email as email, COUNT(o) as orderCount " +
            "FROM User u LEFT JOIN u.orders o GROUP BY u")
    List<UserSummaryProjection> findUserSummaries();
}