package exceptionquiz.api;

/**
 * Вопрос.
 */
public interface Question {
    String getQuestionText();

    String getPrompt();

    String getAnswerText();

    Answer getRightAnswer();
}