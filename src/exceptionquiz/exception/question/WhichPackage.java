package exceptionquiz.exception.question;

import exceptionquiz.api.AbstractQuestion;
import exceptionquiz.exception.ExcData;
import exceptionquiz.application.answer.PackageNameAnswer;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: в какой пакет помещено исключение?
 */
class WhichPackage extends AbstractQuestion {

    public WhichPackage(ExcData excData) {
        super(excData.getExceptionClass());
        rightAnswer = new PackageNameAnswer(exceptionClass);
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
    public String getPrompt() {
        return "Package name:";
    }
}