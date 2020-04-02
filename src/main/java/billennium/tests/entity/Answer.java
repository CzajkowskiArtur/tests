package billennium.tests.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data //TODO  brak konstruktora dla wszystich paramsow. Brak bezparametrowego ktory jest wymagany do tworzenia encji
@Entity
@Table(name = "answer")
public class Answer extends BaseModel{

    @Size(min = 1, max = 50, message = "The answer should be less than 50 characters")
    @NotNull(message = "No answer text provided.")
    private String text;

    @ManyToOne
    @JoinColumn(name="question_id")
    @JsonIgnore
    private Question question;

    @org.hibernate.annotations.Type(type="true_false") // TODO dlaczego adnotacja w taki sposob ? lepszy import niz
    // qualified wydaje mi sie. Dlaczego correctAnswer jest primitywem ?
    @NotNull
    private boolean correctAnswer;

}
