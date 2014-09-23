package exceptionquiz.plugin.priority;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Ответ "1".
 */
class OneAnswer extends AbstractAnswer {
    private static final OneAnswer INSTANCE = new OneAnswer();

    private OneAnswer() {
        variants.add("1");
    }

    static OneAnswer getInstance() {
        return INSTANCE;
    }
}