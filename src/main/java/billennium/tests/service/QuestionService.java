package billennium.tests.service;

import billennium.tests.entity.Question;

import java.util.List;

public interface QuestionService {

    Question findQuestion(Long id);

    List<String> findQuiz(Long id);

    List<String> getListAnswers(Long id);
}
