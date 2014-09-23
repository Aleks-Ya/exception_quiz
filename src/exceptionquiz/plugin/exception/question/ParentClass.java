package exceptionquiz.plugin.exception.question;

import exceptionquiz.plugin.exception.ExcData;
import exceptionquiz.application.answer.PackageAndClassNameAnswer;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: родительский класс?
 */
class ParentClass extends AbstractQuestion {

    public ParentClass(ExcData excData) {
        super(excData.getExceptionClass());
        rightAnswer = new PackageAndClassNameAnswer(exceptionClass.getSuperclass());
    }

    @Override
    public String getQuestionText() {
        return String.format("What is parent of %s?", exceptionClass.getSimpleName());
    }

    @Override
    public String getAnswerText() {
        return exceptionClass.getSuperclass().getName();
    }

    @Override
    public String getPrompt() {
        return "Package and class name:";
    }
}