package exceptionquiz;

/**
 * Принимаемый вариант ответа
 */
public interface Answer {
    boolean isRight(String answer);
}