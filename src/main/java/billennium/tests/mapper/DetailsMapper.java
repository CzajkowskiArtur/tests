package billennium.tests.mapper;

import billennium.tests.entity.ResultDetails;
import billennium.tests.entity.Result;
import billennium.tests.model.QuizModel;
import billennium.tests.model.Response;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DetailsMapper {

    public List<ResultDetails> mapToResultFromResultModel(Result saveResult, ResultModel resultModel, QuizModel quizModel) {
        List<ResultDetails> details = new LinkedList<>();


        List<Response> list = resultModel.getList();

        for (Response response : list) {
            ResultDetails detail = new ResultDetails();
            detail.setQuestion(response.getQuestion());
            detail.setGivenAnswer(response.getSelectedAnswer());
            detail.setResult(saveResult);
            detail.setUserId(quizModel.getUserId());
            details.add(detail);
        }
        return details;
    }
}
