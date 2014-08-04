package exceptionquiz.duplicate;

import exceptionquiz.DuplicateBlocker;
import exceptionquiz.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Блокирует повторяющиеся вопросы.
 */
public class QuestionDuplicateBlocker implements DuplicateBlocker<Question> {
    private final List<Question> questions = new ArrayList<Question>();
    private final int size;

    public QuestionDuplicateBlocker() {
        this(5);
    }

    public QuestionDuplicateBlocker(int size) {
        this.size = size;
    }

    @Override
    public boolean isDuplicate(Question obj) {
        for (Question q : questions) {
            if (q.equals(obj)) {
                return true;
            }
        }
        if (questions.size() >= size) {
            questions.remove(0);
        }
        questions.add(obj);
        return false;
    }
}