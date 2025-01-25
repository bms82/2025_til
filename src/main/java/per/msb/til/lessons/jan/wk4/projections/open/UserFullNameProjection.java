package per.msb.til.lessons.jan.wk4.projections.open;

import org.springframework.beans.factory.annotation.Value;

interface UserFullNameProjection {
    String getFirstName();
    String getLastName();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
