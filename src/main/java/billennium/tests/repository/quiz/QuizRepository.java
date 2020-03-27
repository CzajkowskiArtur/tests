package billennium.tests.repository.quiz;

import billennium.tests.entity.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Override
    List<Quiz> findAll();

}
