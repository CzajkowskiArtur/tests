package billennium.tests.mapper;

import billennium.tests.entity.Details;
import billennium.tests.entity.Result;
import billennium.tests.model.Response;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.List;

@Component
public class ResultMapper {

    public Result mapToResultFromResultModel(ResultModel resultModel) {
        Result result = new Result();
        List<Details> details = new LinkedList<>();

        result.setTotalQuestions(resultModel.getTotalQuestions());
        result.setCorrectQuestions(resultModel.getCorrectQuestions());

        List<Response> list = resultModel.getList();

        for (Response response : list) {
            Details detail = new Details();
            detail.setQuestion(response.getQuestion());
            detail.setGivenAnswer(response.getSelectedAnswer());
            details.add(detail);
        }
        result.setDetails(details);
        return result;
    }
}
