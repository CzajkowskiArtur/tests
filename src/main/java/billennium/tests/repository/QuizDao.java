package billennium.tests.repository;

import billennium.tests.entity.Quiz;
import billennium.tests.mapper.QuizMapper;
import billennium.tests.model.QuizModel;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuizDao implements QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    @Override
    public QuizModel findQuiz() {
        List<Quiz> allQuestionModel = quizRepository.findAll();
        return quizMapper.map(allQuestionModel);
    }

}
