package billennium.tests.service;

import billennium.tests.entity.Question;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    Question mapToQuestion(QuestionModel questionModel) {
        Question question = new Question();
        question.setText(questionModel.getText());
        return question;
    }
}
