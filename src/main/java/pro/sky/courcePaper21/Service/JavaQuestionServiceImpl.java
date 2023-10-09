package pro.sky.courcePaper21.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursePaper2.Exception.QuestionNotFoundException;
import pro.sky.coursePaper2.Question;
import pro.sky.coursePaper2.repository.QuestionRepository;

import java.util.*;
@Service("java")
public class JavaQuestionServiceImpl implements QuestionService {
    private final Random random= new Random();
    private final QuestionRepository repository;

    public JavaQuestionServiceImpl() {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);

    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var questions= repository.getAll();
        var indexRandom= random.nextInt(questions.size());
        int index = 0;
        var it=questions.iterator();
        while (it.hasNext()) {
            var question = it.next();
            if (index == indexRandom) {
                return question;
            }
            index++;    //переключаем вопросы
        }
        throw new QuestionNotFoundException(); //если коллекция пустая
    }
}