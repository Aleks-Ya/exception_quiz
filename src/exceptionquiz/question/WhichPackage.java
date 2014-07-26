package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: в какой пакет помещено исключение?
 */
public class WhichPackage implements Question {
    private final Class exceptionClass;

    public WhichPackage(Class exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    @Override
    public String getQuestionText() {
        return String.format("Which package is %s located?", exceptionClass.getSimpleName());
    }

    @Override
    public String getAnswerText() {
        return exceptionClass.getPackage().getName();
    }

    @Override
    public AnswerType getAnswerType() {
        return AnswerType.ENTER_TEXT;
    }
}