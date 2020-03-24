package billennium.tests.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class QuestionModel {

    private String text;
    private List<String> possibleAnswers;

    @Override
    public String toString() {
        return "QuestionModel{" +
                "text='" + text + '\'' +
                ", possibleAnswers=" + possibleAnswers +
                '}';
    }
}
