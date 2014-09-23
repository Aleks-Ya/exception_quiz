package exceptionquiz.plugin.exception.question;

import exceptionquiz.plugin.exception.ExcSet;
import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;
import exceptionquiz.plugin.exception.excset.Jcp1ExcSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class QuestionGeneratorImplTest {

    @Test(timeout = 1000)
    public void randomQuestion() throws Exception {
        ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionGeneratorImpl rnd = new QuestionGeneratorImpl(excSet, null);
        Set<Class> wasQuestionClass = new HashSet<>(4);
        while (wasQuestionClass.size() != 4) {
            Question q = rnd.randomQuestion();
            wasQuestionClass.add(q.getClass());
        }
    }
}