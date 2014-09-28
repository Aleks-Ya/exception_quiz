package exceptionquiz.api.answer;

/**
 * Правильный ответ "Нет".
 */
public class NoAnswer extends AbstractAnswer {
    private static final NoAnswer INSTANCE = new NoAnswer();

    public NoAnswer() {
        variants.add("no");
        variants.add("n");
        variants.add("нет");
        variants.add("н");
    }

    public static NoAnswer getInstance() {
        return INSTANCE;
    }
}