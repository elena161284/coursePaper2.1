package pro.sky.courcePaper21.Repository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.sky.coursePaper2.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Service("MathRepository")
public class MathQuestionRepository implements QuestionRepository{

    private final Set<Question> questions = new HashSet<>();
    @ResponseStatus
    void init() {
        add("q_math1","a_math1");
        add("q_math2","a_math2");
        add("q_math3","a_math3");
        add("q_math4","a_math4");
        add("q_math5","a_math5");
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