package billennium.tests.service.question;

import billennium.tests.entity.Question;
import billennium.tests.model.QuizModel;

import java.util.List;
// TODO do wszystkich serwisów jestem zwolennikiem nie śmiecenia kodu interfejsami do serwisu jezeli serwis ma tylko
//  jedna implementacje.
//  Możesz doczytać jak chcesz dlaczego kiedyś się tak robiło a teraz już raczej nie trzeba :)
public interface QuestionService {

    Question findQuestion(Long id);

   List<String> findQuiz(Long id);

    List<String> getListAnswers(Long id);

    void save(QuizModel quizModel);
}
