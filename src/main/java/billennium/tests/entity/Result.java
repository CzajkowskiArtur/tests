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

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<Details> details;

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

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }
}

