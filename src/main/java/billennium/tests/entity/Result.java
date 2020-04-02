package billennium.tests.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result extends BaseModel {

    @Column(name = "total_question")
    private Integer totalQuestions;

    @Column(name = "sum_of_correct_answers")
    private Integer correctQuestions;


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




}

