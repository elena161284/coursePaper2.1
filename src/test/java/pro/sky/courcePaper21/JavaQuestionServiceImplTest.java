package pro.sky.courcePaper21;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursePaper2.Exception.NotEnoughtQuestionsException;
import pro.sky.coursePaper2.repository.JavaQuestionRepository;
import pro.sky.coursePaper2.repository.QuestionRepository;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;

class JavaQuestionServiceImplTest {
    private final QuestionRepository questionRepository = new JavaQuestionRepository();

    @BeforeEach
    void setUp() {
        questionRepository.add(new Question(" вопрос 1", " ответ 1"));
        questionRepository.add(new Question(" вопрос 2", " ответ 2"));
        questionRepository.add(new Question(" вопрос 3", " ответ 3"));
        questionRepository.add(new Question(" вопрос 4", " ответ 4"));
    }

    @AfterEach
    void afterEach(){
        Collection <Question> questions = questionRepository.getAll();
        questions.forEach(question -> questionRepository.remove(question));
    }

    @Test
    void addPositiveTest() {


        assertThat(questionRepository.getAll()).hasSize(4);
        Question expected5 = new Question(" вопрос 5"," ответ 5");
        Question expected6 = new Question(" вопрос 6"," ответ 6");
        assertThat(questionRepository.add(expected5.getQuestion(), expected5.getAnswer())).isEqualTo(expected5);
        assertThat(questionRepository.add(expected6)).isEqualTo(new Question(" вопрос 6"," ответ 6"));

        assertThat(questionRepository.getAll()).contains(expected5);
        assertThat(questionRepository.getAll()).contains(expected6);
        assertThat(questionRepository.getAll()).hasSize(6);

    }

    @Test
    void addNegativeTest() {
        Question expected5 = new Question(" вопрос 5"," ответ 5");
        questionRepository.add(expected5);
        assertThatExceptionOfType(NotEnoughtQuestionsException.class)
                .isThrownBy(() -> questionRepository.add(expected5));

    }

    @Test
    void removePositiveTest() {
        Question expected1 = new Question(" вопрос 1", " ответ 1");
        assertThat(questionRepository
                .remove(expected1))
                .isEqualTo(expected1);
    }
    @Test
    void removeNegativeTest() {
        Question expected7 = new Question(" вопрос 7", " ответ 7");
        assertThatExceptionOfType(NotEnoughtQuestionsException.class)
                .isThrownBy(() -> questionRepository.remove(expected7));

    }

    @Test
    void getAll() {
        Assertions.assertThat(questionRepository.getAll())
                .hasSize(4)
                .containsExactlyInAnyOrder(
                        new Question(" вопрос 1", " ответ 1"),
                        new Question(" вопрос 2", " ответ 2"),
                        new Question(" вопрос 3", " ответ 3"),
                        new Question(" вопрос 4", " ответ 4")

                );
    }

    @Test
    void getRandomQuestionTest (){
        assertThat(questionRepository.getRandomQuestion()).isIn(questionRepository.getAll());
    }
}