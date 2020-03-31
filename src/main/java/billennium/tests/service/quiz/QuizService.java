package billennium.tests.service.quiz;

import billennium.tests.model.Response;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;

import java.util.List;

public interface QuizService {

    QuizModel findAllQuiz();

    void updateQuizStatus(Long quizId, String userId);

    QuizModel findQuizById(Long id);

    ResultModel checkAnswers(QuizModel quiz, List<Response> answersBundle);

    void saveResult(ResultModel resultModel, QuizModel quiz);

    QuizModel saveQuiz(String title);
}
