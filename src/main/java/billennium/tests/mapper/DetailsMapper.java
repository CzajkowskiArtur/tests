package billennium.tests.mapper;

import billennium.tests.entity.ExecutingQuiz;
import billennium.tests.entity.Result;
import billennium.tests.entity.ResultDetails;
import billennium.tests.model.Response;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DetailsMapper {

    public List<ResultDetails> mapToResultFromResultModel(ResultModel resultModel, ExecutingQuiz executingQuiz) {
        List<ResultDetails> details = new LinkedList<>();
        List<Response> list = resultModel.getList();

        for (Response response : list) {
            ResultDetails resultDetails = new ResultDetails();
            resultDetails.setQuestion(response.getQuestion());
            resultDetails.setGivenAnswer(response.getSelectedAnswer());
            resultDetails.setExecutingQuiz(executingQuiz);
            details.add(resultDetails);
        }
        return details;
    }
}
