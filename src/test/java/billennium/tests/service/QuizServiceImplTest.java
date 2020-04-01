package billennium.tests.service;


import billennium.tests.entity.QuizDefinition;
import billennium.tests.exception.QuizException;
import billennium.tests.mapper.DetailsMapper;
import billennium.tests.mapper.QuizMapper;
import billennium.tests.mapper.ResultMapper;
import billennium.tests.model.QuizModel;
import billennium.tests.repository.quiz.ExecutingQuizRepository;
import billennium.tests.repository.quiz.QuizDefinitionRepository;
import billennium.tests.repository.test.UserRepository;
import billennium.tests.service.quiz.QuizService;
import billennium.tests.service.quiz.QuizServiceImpl;
import org.junit.Test;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuizServiceImplTest {

    QuizDefinitionRepository quizRepository = mock(QuizDefinitionRepository.class);
    ExecutingQuizRepository executingQuizRepository = mock(ExecutingQuizRepository.class);
    UserRepository userRepository = mock(UserRepository.class);
    QuizMapper quizMapper = mock(QuizMapper.class);
    ResultMapper resultMapper = mock(ResultMapper.class);
    DetailsMapper detailsMapper = mock(DetailsMapper.class);


    QuizService service = new QuizServiceImpl(quizRepository, executingQuizRepository, userRepository, quizMapper, resultMapper, detailsMapper);



    @Test
    public void findExistingQuiz() {

        //given
        QuizDefinition quiz = new QuizDefinition();
        when(quizRepository.findById(anyLong())).thenReturn(java.util.Optional.of(quiz));

        //when
        QuizModel quizById = service.findQuizById(3L);

        //then
        verify(quizRepository, times(1)).findById(3L);
    }

    @Test(expected = QuizException.class)
    public void findNonExistingQuestion() {

        //when
        when(quizRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(null));
        service.findQuizById(10L);
    }
}