package billennium.tests.service;

import billennium.tests.entity.Question;
import billennium.tests.model.QuizModel;

import java.util.List;

public interface QuestionService {

    Question findQuestion(Long id);

    List<String> findQuiz(Long id);

    List<String> getListAnswers(Long id);

    void save(QuizModel quizModel);
}
