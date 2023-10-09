package pro.sky.courcePaper21.Repository;

import pro.sky.coursePaper2.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    boolean getRandomQuestion();
}