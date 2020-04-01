package billennium.tests.service.quiz;

import billennium.tests.model.Response;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;

import java.util.List;
import java.util.UUID;

public interface QuizService {

    QuizModel findQuiz(UUID userId);

    void updateQuizStatus(Long quizId, UUID userId);

    QuizModel findQuizById(Long id);

    ResultModel checkAnswers(QuizModel quiz, List<Response> answersBundle);

    void saveResult(ResultModel resultModel, QuizModel quiz, String userId);

    QuizModel saveQuiz(String title);
}
