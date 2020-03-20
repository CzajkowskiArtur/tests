package billennium.tests.mapper;


import billennium.tests.entity.Question;
import billennium.tests.model.QuizModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    public List<QuizModel> map(List<Question> questions) {
        return questions.stream()
                .map(this::mapToQuestion)
                .collect(Collectors.toList());
    }

    QuizModel mapToQuestion(Question question) {
        return QuizModel.builder()
                .id(String.valueOf(question.getId()))
                .question(question.getText())
                .build();
    }

}

