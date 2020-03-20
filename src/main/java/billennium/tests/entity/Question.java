package billennium.tests.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "question")
public class Question extends BaseModel {

    @Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters")
    @NotNull(message = "Question text not provided")
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
//
//    @OneToOne
//    @JsonIgnore
//    private Answer correctAnswer;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
