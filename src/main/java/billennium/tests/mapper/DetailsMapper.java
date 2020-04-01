package billennium.tests.mapper;

import billennium.tests.entity.ResultDetails;
import billennium.tests.model.Response;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DetailsMapper {

    public List<ResultDetails> mapToResultFromResultModel(ResultModel resultModel) {
        List<ResultDetails> details = new LinkedList<>();
        List<Response> list = resultModel.getList();

        for (Response response : list) {
            ResultDetails detail = new ResultDetails();
            detail.setQuestion(response.getQuestion());
            detail.setGivenAnswer(response.getSelectedAnswer());
            details.add(detail);
        }
        return details;
    }
}
