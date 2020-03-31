package billennium.tests.service.test;

import billennium.tests.entity.User;
import billennium.tests.entity.Quiz;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.repository.test.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    @Override
    public void saveUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userRepository.findById(userId);
    }

    private List<Quiz> getAllQuiz() {
        List<Quiz> allQuizList = quizRepository.findAll();
        return allQuizList;
    }
}
