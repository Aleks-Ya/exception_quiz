package exceptionquiz.plugin.exception;

import exceptionquiz.api.Question;
import exceptionquiz.plugin.exception.ExcSet;
import exceptionquiz.plugin.exception.Jcp1ExcSet;
import exceptionquiz.plugin.exception.QuestionGeneratorImpl;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class QuestionGeneratorImplTest {

    @Test(timeout = 1000)
    public void randomQuestion() throws Exception {
        ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionGeneratorImpl rnd = new QuestionGeneratorImpl(excSet);
        Set<Class> wasQuestionClass = new HashSet<>(4);
        while (wasQuestionClass.size() != 4) {
            Question q = rnd.randomQuestion();
            wasQuestionClass.add(q.getClass());
        }
    }
}