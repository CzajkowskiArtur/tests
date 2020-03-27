package billennium.tests.service.test;

import billennium.tests.entity.IdentyfierTests;
import billennium.tests.entity.Quiz;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.repository.test.IdentyfierTestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final IdentyfierTestsRepository identyfierTestsRepository;
    private final QuizRepository quizRepository;

    @Override
    public void saveUser(String userId) {
        IdentyfierTests identyfierTests = new IdentyfierTests();
        identyfierTests.setUserId(userId);

        IdentyfierTests identyfierTests1 = identyfierTestsRepository.save(identyfierTests);

        List<Quiz> allQuiz = getAllQuiz();
         allQuiz.stream().forEach( f ->
                f.setIdentyfierTests(identyfierTests1)
                );
        quizRepository.saveAll(allQuiz);

    }

    private List<Quiz> getAllQuiz() {
        List<Quiz> allQuizList = quizRepository.findAll();
        return allQuizList;
    }

}
