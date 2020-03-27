package billennium.tests.service.question;

import billennium.tests.entity.Question;
import billennium.tests.entity.Quiz;
import billennium.tests.exception.QuizException;
import billennium.tests.model.QuizModel;
import billennium.tests.repository.question.QuestionRepository;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final QuestionMapper questionMapper;

    @Override
    public Question findQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(QuizException::new);
    }

    @Override
    public List<String> findQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(QuizException::new);
       return quiz.getQuestions().stream()
                .map(m -> m.getText())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListAnswers(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(QuizException::new);
        return question.getAnswers().stream()
                .map(m -> m.getText())
                .collect(Collectors.toList());
    }

    @Override
    public void save(QuizModel quizModel) {
        questionRepository.save(questionMapper.mapToQuestion(quizModel.getQuestionModels().stream().findAny().get()));
    }
}
