package exceptionquiz.application;

import exceptionquiz.api.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Блокирует повторяющиеся вопросы.
 */
class QuestionDuplicateBlocker implements DuplicateBlocker<Question> {
    private final List<Question> questions = new ArrayList<>();
    /**
     * Через limit вопросов блокировка снимается.
     */
    private final int limit;

    public QuestionDuplicateBlocker() {
        this(5);
    }

    public QuestionDuplicateBlocker(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isDuplicate(Question obj) {
        for (Question q : questions) {
            if (q.equals(obj)) {
                return true;
            }
        }
        if (questions.size() >= limit) {
            questions.remove(0);
        }
        questions.add(obj);
        return false;
    }
}