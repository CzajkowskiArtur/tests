package billennium.tests.repository.quiz;

import billennium.tests.entity.ExecutingQuiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutingQuizRepository extends JpaRepository<ExecutingQuiz, Long> {

}
