package billennium.tests.service.user;

import billennium.tests.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface ExecutingQuizService {

    void saveUser(String email);

    Optional<User> findUser(UUID userId);

}
