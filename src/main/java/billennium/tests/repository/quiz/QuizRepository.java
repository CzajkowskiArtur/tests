package billennium.tests.repository.quiz;

import billennium.tests.entity.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Override
    List<Quiz> findAll();

    @Modifying
    @Query("update Quiz q set q.quizStatus = 'IN_PROGRESS', q.userId = :userId where q.id = :quizId")
    void changeQuizStatus(@Param("userId") String userId, @Param("quizId") Long quizId);
}
