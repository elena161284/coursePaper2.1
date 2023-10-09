package pro.sky.courcePaper21.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursePaper2.Exception.NotEnoughtQuestionsException;
import pro.sky.coursePaper2.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService,
                               @Qualifier("math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allMathQuestions = mathQuestionService.getAll();
        var allJavaQuestions = javaQuestionService.getAll();
        if (amount > allJavaQuestions.size() + allMathQuestions.size()) {
            throw new NotEnoughtQuestionsException();
        }
        if (amount == allJavaQuestions.size() + allMathQuestions.size()) {
            List<Question> result = new ArrayList<>(allJavaQuestions.size() +
                    allMathQuestions.size());
            result.addAll(allMathQuestions);
            result.addAll(allJavaQuestions);
            return result;
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            /*if(random.nextBoolean()){
            questions.add(javaQuestionService.getRandomQuestion());
            }else{
            questions.add(mathQuestionService.getRandomQuestion());
            }
             */
            Question randomQuestion = random.nextBoolean()?javaQuestionService.getRandomQuestion() : mathQuestionService.getRandomQuestion();
            questions.add(randomQuestion);
        }
        return questions;
    }
}