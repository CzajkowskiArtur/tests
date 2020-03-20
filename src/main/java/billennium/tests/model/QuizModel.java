package billennium.tests.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class QuizModel {

    private String id;
    private String question;
}
