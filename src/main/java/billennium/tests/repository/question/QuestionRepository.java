package billennium.tests.repository.question;

import billennium.tests.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
// TODO niekoniecznie ale fajnie jak jest adnotacja @Repository wg mnie
public interface QuestionRepository  extends JpaRepository<Question, Long> {

    @Override   // TODO po co ten ovveride to nie wiem
    Optional<Question> findById(Long aLong);
}
