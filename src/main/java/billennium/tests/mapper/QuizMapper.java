package billennium.tests.mapper;


import billennium.tests.entity.Answer;
import billennium.tests.entity.Question;
import billennium.tests.entity.Quiz;
import billennium.tests.model.QuestionModel;
import billennium.tests.model.QuizModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizMapper {

    public QuizModel map(List<Quiz> quiz) {
        return quiz.stream()
                .map(this::mapToQuestion)
                .findAny()
                .get();
//        return quiz.stream()
//                .map(this::mapToQuestion)
//                .collect(Collectors.toList());
    }

    QuizModel mapToQuestion(Quiz quiz) {

        List<QuestionModel> list = new ArrayList<>();
        List<Question> questions = quiz.getQuestions();

       questions.stream().forEach( question ->
            list.add(QuestionModel.builder()
                    .text(question.getText())
                    .possibleAnswers(question.getAnswers().stream().map(Answer::getText).collect(Collectors.toList()))
                    .build())
            );

        return QuizModel.builder()
               .id(String.valueOf(quiz.getId()))
                .questionModels(list)
                .build();
    }

}

