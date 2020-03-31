package billennium.tests.service.test;

import billennium.tests.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    void saveUser(String email);

    Optional<User> findUser(UUID userId);

}
