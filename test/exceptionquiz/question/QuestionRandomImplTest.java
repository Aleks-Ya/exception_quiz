package exceptionquiz.question;

import exceptionquiz.ExcSet;
import exceptionquiz.Question;
import exceptionquiz.QuestionRandom;
import exceptionquiz.excset.Jcp1ExcSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class QuestionRandomImplTest {

    @Test(timeout = 1000)
    public void testRandomQuestion() throws Exception {
        ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionRandom rnd = new QuestionRandomImpl(excSet);
        Set<Class> wasQuestionClass = new HashSet<>(4);
        while (wasQuestionClass.size() != 4) {
            Question q = rnd.randomQuestion();
            wasQuestionClass.add(q.getClass());
        }
    }
}