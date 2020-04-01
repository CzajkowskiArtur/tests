package billennium.tests.controller.web;

import billennium.tests.model.QuizModel;
import billennium.tests.service.quiz.QuizService;
import billennium.tests.service.user.ExecutingQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final QuizService quizService;
    private final ExecutingQuizService executingQuizService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return  "redirect:/createUser";
    }

    @RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
    public String newQuiz() {
        return "createQuiz";
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

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUser() {
        return "createNewUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@RequestParam String email) {
        executingQuizService.saveUser(email);
        return "ending";
    }

    @RequestMapping(value = "/quiz/play/{user_id}", method = RequestMethod.GET)
    public String playQuiz(@PathVariable String user_id, Model model, HttpSession httpSession) {

        UUID userId = UUID.fromString(user_id);
        if (executingQuizService.findUser(userId).isPresent()) {
            QuizModel quiz = quizService.findQuiz(userId);
            model.addAttribute("quiz", quiz);
            httpSession.setAttribute("userId", user_id);
            quizService.updateQuizStatus(Long.valueOf(quiz.getId()), userId);
            return "playQuiz";
        }
        return "errorQuiz";
    }
}

