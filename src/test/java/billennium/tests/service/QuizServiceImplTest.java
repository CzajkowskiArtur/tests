package billennium.tests.service;


import billennium.tests.entity.Quiz;
import billennium.tests.exception.QuizException;
import billennium.tests.mapper.DetailsMapper;
import billennium.tests.mapper.QuizMapper;
import billennium.tests.mapper.ResultMapper;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;
import billennium.tests.repository.quiz.QuizRepository;
import billennium.tests.repository.result.ResultRepository;
import billennium.tests.repository.result.details.DetailsRepository;
import billennium.tests.service.quiz.QuizService;
import billennium.tests.service.quiz.QuizServiceImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuizServiceImplTest {

    QuizRepository quizRepository = mock(QuizRepository.class);
    ResultRepository resultRepository = mock(ResultRepository.class);
    DetailsRepository detailsRepository = mock(DetailsRepository.class);
    QuizMapper quizMapper = mock(QuizMapper.class);
    ResultMapper resultMapper = mock(ResultMapper.class);
    DetailsMapper detailsMapper = mock(DetailsMapper.class);

    QuizService service = new QuizServiceImpl(quizRepository, resultRepository, detailsRepository, quizMapper, resultMapper, detailsMapper);

    @Test
    public void testSaveResultShouldSave() {

        //given
        ResultModel resultModel = new ResultModel(new ArrayList<>());
        QuizModel quizModel = QuizModel.builder().build();

        //when
        service.saveResult(resultModel, quizModel);

        //then
        verify(resultRepository, times(1)).save(resultMapper.mapToResultFromResultModel(resultModel, quizModel));
    }

    @Test
    public void findExistingQuiz() {

        //given
        Quiz quiz = new Quiz();
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