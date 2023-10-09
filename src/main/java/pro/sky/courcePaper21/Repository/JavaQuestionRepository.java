package pro.sky.courcePaper21.Repository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.sky.coursePaper2.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Service("JavaRepository")
public class JavaQuestionRepository implements QuestionRepository{

    private final Set<Question> questions = new HashSet<>();
    @ResponseStatus
    void init() {
        add("q_java1","a_java1");
        add("q_java2","a_java2");
        add("q_java3","a_java3");
        add("q_java4","a_java4");
        add("q_java5","a_java5");
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions); //создали ссылку немодифицированную
    }
}