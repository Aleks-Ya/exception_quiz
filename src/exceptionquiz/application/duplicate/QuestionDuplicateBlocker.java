package exceptionquiz.application.duplicate;

import exceptionquiz.application.DuplicateBlocker;
import exceptionquiz.api.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Блокирует повторяющиеся вопросы.
 */
public class QuestionDuplicateBlocker implements DuplicateBlocker<Question> {
    private final List<Question> questions = new ArrayList<>();
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