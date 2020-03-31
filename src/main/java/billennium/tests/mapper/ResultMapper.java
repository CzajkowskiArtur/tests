package billennium.tests.mapper;

import billennium.tests.entity.Result;
import billennium.tests.model.QuizModel;
import billennium.tests.model.ResultModel;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

    public Result mapToResultFromResultModel(ResultModel resultModel, QuizModel quizModel) {
        Result result = new Result();
//        List<Details> details = new LinkedList<>();

        result.setQuizId(quizModel.getId());
        result.setUserId(quizModel.getUserId());
        result.setTotalQuestions(resultModel.getTotalQuestions());
        result.setCorrectQuestions(resultModel.getCorrectQuestions());

//        List<Response> list = resultModel.getList();
//
//        for (Response response : list) {
//            Details detail = new Details();
//            detail.setQuestion(response.getQuestion());
//            detail.setGivenAnswer(response.getSelectedAnswer());
//            detail.setUserId(quizModel.getUserId());
//            details.add(detail);
//        }
//        result.setDetails(details);
        return result;
    }
}
