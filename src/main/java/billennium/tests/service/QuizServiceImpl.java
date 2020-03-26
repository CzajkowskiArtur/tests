package billennium.tests.service;

import billennium.tests.entity.Answer;
import billennium.tests.mapper.ResultMapper;
import billennium.tests.model.Response;
import billennium.tests.entity.Quiz;
import billennium.tests.entity.Result;
import billennium.tests.exception.QuizException;
import billennium.tests.mapper.QuizMapper;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.repository.result.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);

    private final QuizRepository quizRepository;
    private final ResultRepository resultRepository;
    private final QuizMapper quizMapper;
    private final ResultMapper resultMapper;


    @Override
    public QuizModel findQuiz() {
        List<Quiz> allQuestionModel = quizRepository.findAll();
        return quizMapper.map(allQuestionModel);
    }

    public QuizModel findQuizById(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(QuizException::new);
        return quizMapper.mapToQuestion(quiz);
    }


    @Override
    public ResultModel checkAnswers(QuizModel quiz, List<Response> answersBundle) {
        ResultModel results = new ResultModel();

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
    public void saveResult(ResultModel resultModel) {
        Result result = resultMapper.mapToResultFromResultModel(resultModel);
        resultRepository.save(result);
    }

    @Override
    public QuizModel saveQuiz(String title) {
        Quiz quiz = quizRepository.save(quizMapper.mapToQuiz(title));
        return quizMapper.mapToQuestion(quiz);
    }
}
