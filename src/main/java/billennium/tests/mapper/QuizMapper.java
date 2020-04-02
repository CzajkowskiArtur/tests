package billennium.tests.mapper;

import billennium.tests.entity.Answer;
import billennium.tests.entity.Question;
import billennium.tests.entity.QuizDefinition;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class QuizMapper {

    public QuizModel map(Set<QuizDefinition> quiz) {
        return quiz.stream()
                .map(this::mapToQuizModel)
                .findFirst()
                .get();
    }

    public QuizModel mapToQuizModel(QuizDefinition quiz) {

        List<QuestionModel> list = new ArrayList<>();
        Optional<List<Question>> questions = ofNullable(quiz.getQuestions());

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
                .questionModels(list)
                .build();
    }

    public QuizDefinition mapToQuiz(String titleQuiz) {
        QuizDefinition quiz = new QuizDefinition();
        quiz.setTitle(titleQuiz);
        return quiz;
    }
}

