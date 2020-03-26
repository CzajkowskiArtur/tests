package billennium.tests.controller.web;

import billennium.tests.entity.Quiz;
import billennium.tests.model.QuizModel;
import billennium.tests.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final QuizService quizService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
    public String newQuiz() {
        return "createQuiz";
    }

    @RequestMapping(value = "/quiz/play", method = RequestMethod.GET)
    public String playQuiz(Model model) {
        QuizModel quiz = quizService.findQuiz();
        model.addAttribute("quiz", quiz);
        return "playQuiz";
    }

    @RequestMapping(value = "/createQuiz", method = RequestMethod.POST)
    public String newQuiz(@RequestParam String title) {
        QuizModel newQuiz = quizService.saveQuiz(title);
        return "redirect:/editQuiz/" + Long.valueOf(newQuiz.getId());
    }

    @RequestMapping(value = "/editQuiz/{quiz_id}", method = RequestMethod.GET)
    public String editQuiz(@PathVariable long quiz_id, Model model) {
        QuizModel quiz = quizService.findQuizById(quiz_id);
        model.addAttribute("quiz", quiz);
        return "editQuiz";
    }
}

