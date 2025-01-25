package per.msb.til.lessons.jan.wk4.projections.dynamic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserRepository extends JpaRepository<User, Long> {
    <T> List<T> findByLastName(String lastName, Class<T> type);
}
