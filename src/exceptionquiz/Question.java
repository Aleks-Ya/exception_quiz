package exceptionquiz;

/**
 * Вопрос.
 */
public interface Question {
    String getQuestionText();

    String getAnswerText();

    AnswerType getAnswerType();
}