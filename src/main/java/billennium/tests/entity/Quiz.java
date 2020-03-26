package billennium.tests.entity;

import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz extends BaseModel {

    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
    @NotNull(message = "Please provide a name")
    private String title;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
