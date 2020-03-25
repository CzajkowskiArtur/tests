package billennium.tests.repository;


import lombok.Getter;

@Getter
public class ResultModel {

    private int totalQuestions = 0;
    private int correctQuestions = 0;

    public void addAnswer(boolean isCorrect) {
        totalQuestions++;
        if (isCorrect) {
            correctQuestions++;
        }
    }
}
