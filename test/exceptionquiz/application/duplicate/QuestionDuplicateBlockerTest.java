package exceptionquiz.application.duplicate;

import exceptionquiz.api.Question;
import exceptionquiz.application.DuplicateBlocker;
import exceptionquiz.plugin.exception.excset.Jcp1ExcSet;
import exceptionquiz.plugin.exception.question.QuestionGeneratorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuestionDuplicateBlockerTest {

    //todo Тест не должен зависеть от плагина Exception
    @Test
    public void isDuplicate() {
        int blockerSize = 5;
        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker(blockerSize);
        QuestionGeneratorImpl generator = new QuestionGeneratorImpl(Jcp1ExcSet.getInstance(), blocker);
        int questionCount = 10000;
        List<Question> questions = new ArrayList<>(questionCount);
        for (int i = 0; i < questionCount; i++) {
            questions.add(generator.randomQuestion());
        }
        assertEquals(questionCount, questions.size());

        int assertCount = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question current = questions.get(i);
            for (int q = 1; q <= blockerSize; q++) {
                int beforeNum = i - q;
                if (beforeNum >= 0) {
                    Question before = questions.get(beforeNum);
                    assertNotEquals(current, before);
                    assertCount++;
                }
            }
        }
        final int expectedAssertCount = questionCount * 5 - 5 - 4 - 3 - 2 - 1;
        assertEquals(expectedAssertCount, assertCount);
    }
}