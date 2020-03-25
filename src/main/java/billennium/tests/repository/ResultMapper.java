package billennium.tests.repository;

import billennium.tests.entity.Result;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

    public  Result mapToResultFromResultModel(ResultModel resultModel) {
        Result result = new Result();
        result.setTotalQuestions(resultModel.getTotalQuestions());
        result.setCorrectQuestions(resultModel.getCorrectQuestions());
        return result;
    }
}
