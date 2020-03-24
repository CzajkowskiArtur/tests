package billennium.tests.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Builder

public class QuizModel {

    private String id;
    private List<QuestionModel> questionModels;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<QuestionModel> getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(List<QuestionModel> questionModels) {
        this.questionModels = questionModels;
    }

    @Override
    public String toString() {
        return "QuizModel{" +
                "id='" + id + '\'' +
                ", questionModels=" + questionModels +
                '}';
    }
}
