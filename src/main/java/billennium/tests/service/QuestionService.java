package billennium.tests.service;

import billennium.tests.entity.Answer;
import billennium.tests.entity.Question;
import billennium.tests.entity.Quiz;

import java.util.List;

public interface QuestionService {

    Question findQuestion(Long id);

    List<String> findQuiz(Long id);

    List<String> getListAnswers(Long id);
}
