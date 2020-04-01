package billennium.tests.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "answer")
public class Answer extends BaseModel{

    @Size(min = 1, max = 50, message = "The answer should be less than 50 characters")
    @NotNull(message = "No answer text provided.")
    private String text;

    @ManyToOne
    @JoinColumn(name="question_id")
//    @JsonIgnore
    private Question question;

    @org.hibernate.annotations.Type(type="true_false")
    @NotNull
    private boolean correctAnswer;

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer [text=" + text + ", question=" + question + ", order="  + ", createdDate="
                + "]";
    }
}
