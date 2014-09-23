package exceptionquiz.plugin.priority;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Ответ "2".
 */
class TwoAnswer extends AbstractAnswer {
    private static final TwoAnswer INSTANCE = new TwoAnswer();

    private TwoAnswer() {
        variants.add("2");
    }

    static TwoAnswer getInstance() {
        return INSTANCE;
    }
}