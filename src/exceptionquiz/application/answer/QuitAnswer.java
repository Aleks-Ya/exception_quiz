package exceptionquiz.application.answer;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Выход из приложения.
 */
public class QuitAnswer extends AbstractAnswer {
    private static final QuitAnswer INSTANCE = new QuitAnswer();

    public QuitAnswer() {
        variants.add("q");
        variants.add("quit");
        variants.add("e");
        variants.add("exit");
    }

    public static QuitAnswer getInstance() {
        return INSTANCE;
    }
}