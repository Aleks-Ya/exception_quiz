package exceptionquiz;

/**
 * Вариант ответа на вопрос.
 */
public class Answer {
    private String text;

    public Answer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
