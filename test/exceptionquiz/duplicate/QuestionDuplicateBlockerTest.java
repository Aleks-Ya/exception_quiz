package exceptionquiz.duplicate;

import exceptionquiz.DuplicateBlocker;
import exceptionquiz.Question;
import exceptionquiz.answer.NoAnswer;
import exceptionquiz.answer.PackageNameAnswer;
import exceptionquiz.answer.YesAnswer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionDuplicateBlockerTest {

    @Test
    public void isDuplicate() throws Exception {
        Question q1 = mock(Question.class);
        when(q1.getAnswerText()).thenReturn("answer_1");
        when(q1.getPrompt()).thenReturn("prompt_1");
        when(q1.getQuestionText()).thenReturn("question_1");
        when(q1.getRightAnswer()).thenReturn(YesAnswer.getInstance());

        Question q2 = mock(Question.class);
        when(q2.getAnswerText()).thenReturn("answer_2");
        when(q2.getPrompt()).thenReturn("prompt_2");
        when(q2.getQuestionText()).thenReturn("question_2");
        when(q2.getRightAnswer()).thenReturn(NoAnswer.getInstance());

        Question q3 = mock(Question.class);
        when(q3.getAnswerText()).thenReturn("answer_3");
        when(q3.getPrompt()).thenReturn("prompt_3");
        when(q3.getQuestionText()).thenReturn("question_3");
        when(q3.getRightAnswer()).thenReturn(new PackageNameAnswer(Class.class));

        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker(2);
        assertFalse(blocker.isDuplicate(q1));
        assertTrue(blocker.isDuplicate(q1));
        assertFalse(blocker.isDuplicate(q2));
        assertTrue(blocker.isDuplicate(q2));
        assertTrue(blocker.isDuplicate(q1));
        assertFalse(blocker.isDuplicate(q3));
        assertTrue(blocker.isDuplicate(q3));
        assertFalse(blocker.isDuplicate(q1));
        assertTrue(blocker.isDuplicate(q1));
    }
}