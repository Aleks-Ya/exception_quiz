package exceptionquiz.plugin.priority;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Ответ "0".
 */
class ZeroAnswer extends AbstractAnswer {
    private static final ZeroAnswer INSTANCE = new ZeroAnswer();

    private ZeroAnswer() {
        variants.add("0");
    }

    static ZeroAnswer getInstance() {
        return INSTANCE;
    }
}