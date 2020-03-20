package billennium.tests.repository;

import billennium.tests.entity.Question;
import billennium.tests.mapper.QuestionMapper;
import billennium.tests.model.QuizModel;
import billennium.tests.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuizDao implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionMapper questionMapper;

    @Override
    public List<QuizModel> findTest() {
        List<Question> allQuestionModel = quizRepository.findAll();
        return questionMapper.map(allQuestionModel);
    }


}
