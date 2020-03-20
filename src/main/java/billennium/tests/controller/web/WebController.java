package billennium.tests.controller.web;

import billennium.tests.model.QuizModel;
import billennium.tests.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final QuizService quizService;

    @RequestMapping(value = "/quiz/play", method = RequestMethod.GET)
    public String playQuiz(Model model) {
        List<QuizModel> question = quizService.findTest();
        model.addAttribute("question", question);
        return "playQuiz";
    }
}

