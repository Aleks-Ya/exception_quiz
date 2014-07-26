package exceptionquiz;

/**
 * Опросник.
 */
public interface Inquirer {
    void showQuestionText(Question question);

    String takeAnswerText();

    void showRightAnswerText(String answerText);
}