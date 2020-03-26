package billennium.tests.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Table
@Entity(name = "indentyfier_tests")
public class IdentyfierTests {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToMany
    private List<Quiz> quizList;

    @Column(name = "user")
    private String user_id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Calendar createdDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
