package exceptionquiz.application;

/**
 * Принимаемый вариант ответа
 */
public interface Answer {
    boolean isRight(String answer);
}