package billennium.tests.service.user;

import billennium.tests.entity.ExecutingQuiz;
import billennium.tests.entity.QuizDefinition;
import billennium.tests.entity.QuizStatus;
import billennium.tests.entity.User;
import billennium.tests.repository.quiz.ExecutingQuizRepository;
import billennium.tests.repository.quiz.QuizDefinitionRepository;
import billennium.tests.repository.test.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExecutingQuizServiceImpl implements ExecutingQuizService {

    private final UserRepository userRepository;
    private final QuizDefinitionRepository quizDefinitionRepository;
    private final ExecutingQuizRepository executingQuizRepository;


    @Override
    public void saveUser(String email) {
        User user = new User();
        user.setEmail(email);

        ExecutingQuiz executingQuiz = new ExecutingQuiz();
        executingQuiz.setUserId(user);
        executingQuiz.setQuizStatus(QuizStatus.READY_TO_START);
        executingQuiz.setQuiz(quizDefinitionRepository.findAll().stream().findAny().get()); //TODO znowu optional bez
        // sprawdzenia
        executingQuizRepository.save(executingQuiz);
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userRepository.findById(userId);
    }

    private List<QuizDefinition> getAllQuiz() { // TODO unused method
        List<QuizDefinition> allQuizList = quizDefinitionRepository.findAll();
        return allQuizList;
    }
}
