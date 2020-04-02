package billennium.tests.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "executing_quiz")
public class ExecutingQuiz extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private QuizDefinition quiz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private Result result;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "result_details_id")
    private List<ResultDetails> resultDetails;

    @Enumerated(EnumType.STRING)
    private QuizStatus quizStatus;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public QuizDefinition getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizDefinition quiz) {
        this.quiz = quiz;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public QuizStatus getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(QuizStatus quizStatus) {
        this.quizStatus = quizStatus;
    }

    public List<ResultDetails> getResultDetails() {
        return resultDetails;
    }

    public void setResultDetails(List<ResultDetails> resultDetails) {
        this.resultDetails = resultDetails;
    }
}
