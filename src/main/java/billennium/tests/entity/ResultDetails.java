package billennium.tests.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result_details")
public class ResultDetails extends BaseModel {

    @Column(name = "asked_question")
    private String question;

    @Column(name = "given_answer")
    private String givenAnswer;

    @ManyToOne
    @JsonIgnore
    private ExecutingQuiz executingQuiz;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public ExecutingQuiz getExecutingQuiz() {
        return executingQuiz;
    }

    public void setExecutingQuiz(ExecutingQuiz executingQuiz) {
        this.executingQuiz = executingQuiz;
    }
}
