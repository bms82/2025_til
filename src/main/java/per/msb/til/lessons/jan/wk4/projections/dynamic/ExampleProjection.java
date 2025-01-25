package per.msb.til.lessons.jan.wk4.projections.dynamic;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ExampleProjection {

    UserRepository userRepository;

    List<UserFirstNameProjection> firstNameProjections = userRepository.findByLastName("Doe", UserFirstNameProjection.class);
    List<UserEmailProjection> emailProjections = userRepository.findByLastName("Doe", UserEmailProjection.class);
    List<UserFullDetailsProjection> fullDetailsProjections = userRepository.findByLastName("Doe", UserFullDetailsProjection.class);
}