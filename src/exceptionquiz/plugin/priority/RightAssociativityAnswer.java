package exceptionquiz.plugin.priority;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Ответ "Правая ассоциативность".
 */
class RightAssociativityAnswer extends AbstractAnswer {
    private static final RightAssociativityAnswer INSTANCE = new RightAssociativityAnswer();

    private RightAssociativityAnswer() {
        variants.add("r");
        variants.add("right");
    }

    static RightAssociativityAnswer getInstance() {
        return INSTANCE;
    }
}