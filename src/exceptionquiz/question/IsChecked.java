package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.ExcData;
import exceptionquiz.Question;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: проверяемое или непроверяемое исключение?
 */
public class IsChecked implements Question {
    private final Class exceptionClass;

    public IsChecked(ExcData excData) {
        this.exceptionClass = excData.getExceptionClass();
    }

    @Override
    public String getQuestionText() {
        return String.format("Is %s checked exception?", exceptionClass.getSimpleName());
    }

    @Override
    public String getAnswerText() {
        boolean isChecked = true;
        Class clazz = exceptionClass.getSuperclass();
        do {
            clazz = clazz.getSuperclass();
            if (clazz == RuntimeException.class) {
                isChecked = false;
                break;
            }
        } while (clazz != Object.class);
        return isChecked ?
                exceptionClass.getSimpleName() + " is checked exception"
                : exceptionClass.getSimpleName() + " is UN checked exception";
    }

    @Override
    public AnswerType getAnswerType() {
        return AnswerType.YES_NO;
    }
}
