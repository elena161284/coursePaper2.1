package pro.sky.courcePaper21.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursePaper2.Question;
import pro.sky.coursePaper2.Service.ExaminerServiceImpl;

import java.util.Collection;
@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }
    @GetMapping("/{amount}") //localhost:8080/exam/5
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }
}