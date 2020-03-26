package billennium.tests.controller.web.rest;

import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import billennium.tests.service.QuestionService;
import billennium.tests.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(QuestionController.ROOT_MAPPING)
@RequiredArgsConstructor
public class QuestionController {

    public static final String ROOT_MAPPING = "/api/questions";

    private final QuizService quizService;
    private final QuestionService questionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestParam String text, Long quiz_id) {

        QuizModel quizModel = quizService.findQuizById(quiz_id);

        quizModel.getQuestionModels().add(QuestionModel.builder()
                .text(text)
                .build());

        questionService.save(quizModel);

    }

}
