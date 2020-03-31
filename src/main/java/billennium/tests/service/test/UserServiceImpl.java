package billennium.tests.service.test;

import billennium.tests.entity.IdentyfierTests;
import billennium.tests.entity.Quiz;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.repository.test.IdentyfierTestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final IdentyfierTestsRepository identyfierTestsRepository;
    private final QuizRepository quizRepository;

    @Override
    public void saveUser(String userId) {
        IdentyfierTests identyfierTests = new IdentyfierTests();
        identyfierTests.setUserId(userId);
        identyfierTestsRepository.save(identyfierTests);
    }

    @Override
    public Optional<IdentyfierTests> findUser(UUID userId) {
        return identyfierTestsRepository.findById(userId);
    }

    private List<Quiz> getAllQuiz() {
        List<Quiz> allQuizList = quizRepository.findAll();
        return allQuizList;
    }
}
