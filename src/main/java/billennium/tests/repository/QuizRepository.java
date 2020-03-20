package billennium.tests.repository;

import billennium.tests.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface QuizRepository extends JpaRepository<Question, Long> {

    @Override
    List<Question> findAll();
}
