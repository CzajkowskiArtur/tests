package billennium.tests.mapper;

import billennium.tests.entity.Question;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question mapToQuestion(QuestionModel questionModel) {
        Question question = new Question();
        question.setText(questionModel.getText());
        return question;
    }
}
