package exceptionquiz.plugin.exception;

import exceptionquiz.api.answer.NoAnswer;
import exceptionquiz.api.answer.YesAnswer;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: проверяемое или непроверяемое исключение?
 */
class IsChecked extends AbstractQuestion {
    private final boolean isChecked;

    public IsChecked(ExcData excData) {
        super(excData.getExceptionClass());
        isChecked = isCheckedException(exceptionClass);
        if (isChecked) {
            rightAnswer = YesAnswer.getInstance();
        } else {
            rightAnswer = NoAnswer.getInstance();
        }

    }

    @Override
    public String getQuestionText() {
        return String.format("Is %s checked exception?", exceptionClass.getSimpleName());
    }

    @Override
    public String getAnswerText() {
        return isChecked ?
                exceptionClass.getSimpleName() + " is checked exception"
                : exceptionClass.getSimpleName() + " is unchecked exception";
    }

    private boolean isCheckedException(Class clazz) {
        boolean checked = true;
        Class superclass = clazz;
        while (superclass != Object.class) {
            if (superclass == RuntimeException.class || superclass == Error.class) {
                checked = false;
                break;
            }
            superclass = superclass.getSuperclass();
        }
        return checked;
    }

    @Override
    public String getPrompt() {
        return "y/n:";
    }
}