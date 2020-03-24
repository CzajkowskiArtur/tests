package billennium.tests.repository.question;

import billennium.tests.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QuestionRepository  extends JpaRepository<Question, Long> {

    @Override
    Optional<Question> findById(Long aLong);
}
