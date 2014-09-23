package exceptionquiz.plugin.priority;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Ответ "Левая ассоциативность".
 */
class LeftAssociativityAnswer extends AbstractAnswer {
    private static final LeftAssociativityAnswer INSTANCE = new LeftAssociativityAnswer();

    private LeftAssociativityAnswer() {
        variants.add("l");
        variants.add("left");
    }

    static LeftAssociativityAnswer getInstance() {
        return INSTANCE;
    }
}