package billennium.tests.mapper;

import billennium.tests.JpaRepositoryIT;
import billennium.tests.entity.Quiz;
import billennium.tests.model.QuizModel;
import billennium.tests.repository.quiz.QuizRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;

@ComponentScan(basePackages = "billennium.tests.mapper")
public class QuizMapperTest extends JpaRepositoryIT {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizMapper sut;

    @Test
    public void shouldMapToQuizModel() {

        //given
        List<Quiz> quiz = quizRepository.findAll();


        //when
        QuizModel quizModel = sut.map(new HashSet<>(quiz));

        //then
        assertThat(quizModel.getQuestionModels().get(1).getText(),is("JVM TO"));
    }

}