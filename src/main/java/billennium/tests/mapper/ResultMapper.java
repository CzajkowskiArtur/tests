package billennium.tests.mapper;

import billennium.tests.entity.Result;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

    public Result mapToResultFromResultModel(ResultModel resultModel, QuizModel quizModel) {
        Result result = new Result();
        result.setTotalQuestions(resultModel.getTotalQuestions());
        result.setCorrectQuestions(resultModel.getCorrectQuestions());
        return result;
    }
}
