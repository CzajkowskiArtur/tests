package billennium.tests.repository.quiz;

import billennium.tests.entity.QuizDefinition;
import billennium.tests.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDefinitionRepository extends JpaRepository<QuizDefinition, Long> {

    @Override
    List<QuizDefinition> findAll();



}
