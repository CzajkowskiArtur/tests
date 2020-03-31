package billennium.tests.mapper;

import billennium.tests.entity.Answer;
import billennium.tests.entity.Question;
import billennium.tests.entity.Quiz;
import billennium.tests.entity.QuizStatus;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class QuizMapper {

    public QuizModel map(Set<Quiz> quiz) {
        return quiz.stream()
                .filter(f -> f.getQuizStatus() == QuizStatus.FREE)
                .map(this::mapToQuestion)
                .findFirst()
                .get();
    }

    public QuizModel mapToQuestion(Quiz quiz) {

        List<QuestionModel> list = new ArrayList<>();
        Optional<List<Question>> questions = ofNullable(quiz.getQuestions());

        quiz.getUserId();

        questions.ifPresent(f ->
                f.forEach(question ->
                        list.add(QuestionModel.builder()
                                .id(question.getId())
                                .text(question.getText())
                                .possibleAnswers(question.getAnswers().stream().map(Answer::getText).collect(Collectors.toList()))
                                .correctAnswers(question.getCorrectAnswer().getText())
                                .isCorrect(question.getCorrectAnswer().isCorrectAnswer())
                                .build())
                )
        );


        return QuizModel.builder()
                .id(String.valueOf(quiz.getId()))
                .userId(quiz.getUserId())
                .questionModels(list)
                .build();
    }

    public Quiz mapToQuiz(String titleQuiz) {
        Quiz quiz = new Quiz();
        quiz.setTitle(titleQuiz);
        return quiz;
    }
}

