package exceptionquiz.api;

import exceptionquiz.application.Answer;

/**
 * Вопрос.
 */
public interface Question {
    String getQuestionText();

    String getPrompt();

    String getAnswerText();

    Answer getRightAnswer();
}