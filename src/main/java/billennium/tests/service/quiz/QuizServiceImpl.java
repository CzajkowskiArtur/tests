package billennium.tests.service.quiz;

import billennium.tests.entity.ExecutingQuiz;
import billennium.tests.entity.QuizDefinition;
import billennium.tests.entity.QuizStatus;
import billennium.tests.entity.User;
import billennium.tests.mapper.DetailsMapper;
import billennium.tests.mapper.ResultMapper;
import billennium.tests.model.Response;
import billennium.tests.entity.Result;
import billennium.tests.exception.QuizException;
import billennium.tests.mapper.QuizMapper;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;
import billennium.tests.repository.quiz.ExecutingQuizRepository;
import billennium.tests.repository.quiz.QuizDefinitionRepository;
import billennium.tests.repository.test.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);

    private final QuizDefinitionRepository quizDefinitionRepository;
    private final ExecutingQuizRepository executingQuizRepository;
    private final UserRepository userRepository;
    private final QuizMapper quizMapper;
    private final ResultMapper resultMapper;
    private final DetailsMapper detailsMapper;


    @Override
    public QuizModel findQuiz(UUID userId) {
        QuizDefinition quizDefinition = userRepository.getOne(userId).getExecutingQuiz().getQuiz();
        return quizMapper.mapToQuizModel(quizDefinition);
    }

    @Override
    @Transactional
    public void updateQuizStatus(Long quizId, UUID userId) {
        User user = userRepository.findById(userId).get();
        QuizDefinition quiz = quizDefinitionRepository.findById(quizId).get();
    }

    public QuizModel findQuizById(Long id) {
        QuizDefinition quiz = quizDefinitionRepository.findById(id).orElseThrow(QuizException::new);
        return quizMapper.mapToQuizModel(quiz);
    }


    @Override
    public ResultModel checkAnswers(QuizModel quiz, List<Response> answersBundle) {
        ResultModel results = new ResultModel(answersBundle);

        for (QuestionModel questionModel : quiz.getQuestionModels()) {
            for (Response bundle : answersBundle) {
                if (bundle.getQuestion().equals(questionModel.getText())) {
                    results.addAnswer(checkIsCorrectAnswer(questionModel, bundle.getSelectedAnswer()));
                    break;
                }
            }
        }
        return results;
    }

    private boolean checkIsCorrectAnswer(QuestionModel questionModel, String selectedAnswer) {
        return questionModel.getCorrectAnswers().equals(selectedAnswer);
    }

    @Override
    @Transactional
    public void saveResult(ResultModel resultModel, QuizModel quizModel, String userId) {
        ExecutingQuiz executingQuiz = userRepository.getOne(UUID.fromString(userId)).getExecutingQuiz();
        executingQuiz.setResult(resultMapper.mapToResultFromResultModel(resultModel, quizModel));
        executingQuiz.setQuizStatus(QuizStatus.DONE);
        executingQuiz.setResultDetails(detailsMapper.mapToResultFromResultModel(resultModel, executingQuiz));
        executingQuizRepository.save(executingQuiz);
    }

    @Override
    public QuizModel saveQuiz(String title) {
        QuizDefinition quiz = quizDefinitionRepository.save(quizMapper.mapToQuiz(title));
        return quizMapper.mapToQuizModel(quiz);
    }
}
