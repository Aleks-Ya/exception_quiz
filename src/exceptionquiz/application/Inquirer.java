package exceptionquiz.application;

import exceptionquiz.api.Question;

/**
 * Опросник.
 */
interface Inquirer {
    void showQuestionText(Question question);

    String takeAnswerText(String prompt);

    void showRightAnswerText(String answerText);

    void showStatistic(Statistic statistic);

    void showInfoMessage(String message);
}