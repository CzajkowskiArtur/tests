package billennium.tests.controller.web.rest;

import billennium.tests.entity.Question;
import billennium.tests.model.QuizModel;
import billennium.tests.model.Response;
import billennium.tests.model.ResultModel;
import billennium.tests.service.question.QuestionService;
import billennium.tests.service.quiz.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(QuizController.ROOT_MAPPING)
@RequiredArgsConstructor
public class QuizController {

    public static final String ROOT_MAPPING = "/api/quiz"; //TODO to samo co w QuestionController

    private final QuizService quizService;
    private final QuestionService questionService;


    @RequestMapping(value = "/{quiz_id}/questions", method = RequestMethod.GET) //TODO wszystkie value w
    // requestMapping
    // tez do controllerConstatnst - bo tutaj np quiz_id sie powtarza a może być z jednego constantsam Prosba do
    // wszystkich metod w controllerach: uzywaj @GetMapping/@PostMapping itp zamiast @RequestMapping z okresleniem
    // metody
    @ResponseStatus(HttpStatus.OK)
    public List<String> findQuestions(@PathVariable Long quiz_id) {
        return questionService.findQuiz(quiz_id);
    }

    @RequestMapping(value = "/{question_id}/answers", method = RequestMethod.GET) //TODO
    @ResponseStatus(HttpStatus.OK)
    public List<String> findAnswers(@PathVariable Long question_id) {
        Long l = question_id + 1;
        Question question = questionService.findQuestion(l);
        return questionService.getListAnswers(question.getId());
    }

    @RequestMapping(value = "/{quiz_id}/submitAnswers", method = RequestMethod.POST, produces = "application/json") //TODO
    @ResponseStatus(HttpStatus.OK)
    public void playQuiz(@PathVariable long quiz_id, @RequestBody List<Response> answersBundle, HttpSession httpSession) {
        Object userId = httpSession.getAttribute("userId");
        QuizModel quiz = quizService.findQuizById(quiz_id);
        ResultModel resultModel = quizService.checkAnswers(quiz, answersBundle);
        quizService.saveResult(resultModel, quiz, userId.toString());

    }
}
