package billennium.tests.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class QuizModel {

    private String id;
    private List<QuestionModel> questionModels;
}
