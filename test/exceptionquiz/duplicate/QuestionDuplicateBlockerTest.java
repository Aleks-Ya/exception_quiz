package exceptionquiz.duplicate;

import exceptionquiz.DuplicateBlocker;
import exceptionquiz.Question;
import exceptionquiz.QuestionGenerator;
import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.question.QuestionGeneratorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuestionDuplicateBlockerTest {

    @Test
    public void isDuplicate() {
        int blockerSize = 5;
        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker(blockerSize);
        QuestionGenerator generator = new QuestionGeneratorImpl(Jcp1ExcSet.getInstance(), blocker);
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