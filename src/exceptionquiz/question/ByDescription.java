package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;

/**
 * Вопрос.
 * Известно: описание исключения.
 * Вопрос: пакет и название исключения?
 */
public class ByDescription implements Question {

    private final String description;
    private final Class exceptionClass;

    public ByDescription(String description, Class exceptionClass) {

        this.description = description;
        this.exceptionClass = exceptionClass;
    }

    @Override
    public String getQuestionText() {
        return String.format("Which exception is used for \"%s\"?", description);
    }

    @Override
    public String getAnswerText() {
        return exceptionClass.getName();
    }

    @Override
    public AnswerType getAnswerType() {
        return AnswerType.ENTER_TEXT;
    }
}