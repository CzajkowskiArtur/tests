package billennium.tests.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "result")
public class Result extends BaseModel {

    @Column(name = "total_question")
    private Integer totalQuestions;

    @Column(name = "sum_of_correct_answers")
    private Integer correctQuestions;

    @Column(name = "quiz_id")
    private String quizId;

    @Column(name = "user_id")
    private String userId;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<ResultDetails> details;

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Integer getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(Integer correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ResultDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ResultDetails> details) {
        this.details = details;
    }
}

