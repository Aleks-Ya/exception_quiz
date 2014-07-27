package exceptionquiz;

/**
 * Опросник.
 */
public interface Inquirer {
    void showQuestionText(Question question);

    String takeAnswerText(String prompt);

    void showRightAnswerText(String answerText);
}