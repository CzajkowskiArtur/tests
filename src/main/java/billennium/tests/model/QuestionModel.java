package billennium.tests.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class QuestionModel {

    private Long id;
    private String text;
    private List<String> possibleAnswers;
    private String correctAnswers;
    private boolean isCorrect;
}
