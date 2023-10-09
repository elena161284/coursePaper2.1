package pro.sky.courcePaper21.Service;

import pro.sky.coursePaper2.Question;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}