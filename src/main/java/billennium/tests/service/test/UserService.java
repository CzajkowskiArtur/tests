package billennium.tests.service.test;

import billennium.tests.entity.IdentyfierTests;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    void saveUser(String email);

    Optional<IdentyfierTests> findUser(UUID userId);

}
