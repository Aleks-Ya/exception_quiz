package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.ExcData;
import exceptionquiz.Question;

/**
 * Вопрос.
 * Известно: описание исключения.
 * Вопрос: пакет и название исключения?
 */
public class ByDescription implements Question {

    private final ExcData excData;

    public ByDescription(ExcData excData) {
        this.excData = excData;
    }

    @Override
    public String getQuestionText() {
        return String.format("Which exception is used for \"%s\"?", excData.getExceptionDescription());
    }

    @Override
    public String getAnswerText() {
        return excData.getExceptionClass().getName();
    }

    @Override
    public AnswerType getAnswerType() {
        return AnswerType.ENTER_TEXT;
    }
}