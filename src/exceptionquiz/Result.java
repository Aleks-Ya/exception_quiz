package exceptionquiz;

/**
 * Результат ответа на вопрос.
 */
public class Result {
    private boolean isRight;

    public Result(boolean isRight) {
        this.isRight = isRight;
    }

    public boolean isRight() {
        return isRight;
    }
}
