package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: родительский класс?
 */
public class ParentClass implements Question {
    private final Class exceptionClass;

    public ParentClass(Class exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    @Override
    public String getQuestionText() {
        return String.format("What is parent class of %s?", exceptionClass.getSimpleName());
    }

    @Override
    public String getAnswerText() {
        return exceptionClass.getSuperclass().getName();
    }

    @Override
    public AnswerType getAnswerType() {
        return AnswerType.ENTER_TEXT;
    }
}
