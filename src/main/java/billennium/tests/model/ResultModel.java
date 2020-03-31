package billennium.tests.model;


import lombok.Getter;

import java.util.List;

@Getter
public class ResultModel {

    private int totalQuestions = 0;
    private int correctQuestions = 0;
    private List<Response> list;

    public ResultModel(List<Response> list) {
        this.list = list;
    }

    public void addAnswer(boolean isCorrect) {
        totalQuestions++;
        if (isCorrect) {
            correctQuestions++;
        }
    }
}
