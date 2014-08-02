package exceptionquiz.answer;

/**
 * Выход из приложения.
 */
public class QuitAnswer extends AbstractAnswer {
    private static final QuitAnswer instance = new QuitAnswer();

    public QuitAnswer() {
        variants.add("q");
        variants.add("exit");
        variants.add("quit");
    }

    public static QuitAnswer getInstance() {
        return instance;
    }
}