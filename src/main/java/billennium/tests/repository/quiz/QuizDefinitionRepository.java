package billennium.tests.repository.quiz;

import billennium.tests.entity.QuizDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDefinitionRepository extends JpaRepository<QuizDefinition, Long> {

}
