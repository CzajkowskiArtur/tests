package billennium.tests.service;

import billennium.tests.controller.web.rest.Response;
import billennium.tests.model.QuizModel;
import billennium.tests.repository.ResultModel;

import java.util.List;

public interface QuizService {

    QuizModel findQuiz();

    QuizModel findQuizById(Long id);

    ResultModel checkAnswers(QuizModel quiz, List<Response> answersBundle);

    void saveResult(ResultModel resultModel);
}
