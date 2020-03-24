package billennium.tests.controller.web.rest;

import billennium.tests.entity.Answer;
import billennium.tests.entity.Question;
import billennium.tests.entity.Quiz;
import billennium.tests.model.QuizModel;
import billennium.tests.service.QuestionService;
import billennium.tests.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(QuizController.ROOT_MAPPING)
@RequiredArgsConstructor
public class QuizController {

    public static final String ROOT_MAPPING = "/api/quiz";

    private final QuizService quizService;
    private final QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public QuizModel findTest() {
        return quizService.findQuiz();
    }

    @RequestMapping(value = "/{quiz_id}/questions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<String> findQuestions(@PathVariable Long quiz_id) {
        return questionService.findQuiz(quiz_id);
    }

    @RequestMapping(value = "/{question_id}/answers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<String> findAnswers(@PathVariable Long question_id) {
        Question question = questionService.findQuestion(question_id);
        return questionService.getListAnswers(question.getId());
    }

//    @RequestMapping(value = "/{quiz_id}/submitAnswers", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    public void playQuiz(@PathVariable long quiz_id, @RequestBody List<Response> answersBundle) {
//        QuizModel quiz = quizService.findQuiz();
//
//    }




}
