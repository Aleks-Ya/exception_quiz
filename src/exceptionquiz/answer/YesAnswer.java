package exceptionquiz.answer;

/**
 * Правильный ответ "Да".
 */
public class YesAnswer extends YesNoAbstractAnswer {
    private static final YesAnswer instance = new YesAnswer();

    private YesAnswer() {
        variants.add("yes");
        variants.add("y");
        variants.add("да");
        variants.add("д");
    }

    public static YesAnswer getInstance() {
        return instance;
    }
}