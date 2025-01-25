package per.msb.til.lessons.jan.wk4.projections.open;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserRepository extends JpaRepository<User, Long> {
    List<UserFullNameProjection> findAllBy();
}
