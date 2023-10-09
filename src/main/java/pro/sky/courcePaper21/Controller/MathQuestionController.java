package pro.sky.courcePaper21.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursePaper2.Question;
import pro.sky.coursePaper2.Service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("math") QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add") //localhost:8080/exam/java/add?question=foo
    public Question add(@RequestParam String question,
                        @RequestParam String answer)
    {
        return questionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer)
    {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}