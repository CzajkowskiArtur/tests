package billennium.tests.mapper;

import billennium.tests.entity.Details;
import billennium.tests.entity.Result;
import billennium.tests.model.QuizModel;
import billennium.tests.model.Response;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DetailsMapper {

    public List<Details> mapToResultFromResultModel(Result saveResult, ResultModel resultModel, QuizModel quizModel) {
        List<Details> details = new LinkedList<>();


        List<Response> list = resultModel.getList();

        for (Response response : list) {
            Details detail = new Details();
            detail.setQuestion(response.getQuestion());
            detail.setGivenAnswer(response.getSelectedAnswer());
            detail.setResult(saveResult);
            detail.setUserId(quizModel.getUserId());
            details.add(detail);
        }
        return details;
    }
}
