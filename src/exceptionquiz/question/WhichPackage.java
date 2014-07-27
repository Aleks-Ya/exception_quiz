package exceptionquiz.question;

import exceptionquiz.ExcData;
import exceptionquiz.answer.PackageNameAnswer;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: в какой пакет помещено исключение?
 */
public class WhichPackage extends ClassNameAbstractQuestion {

    public WhichPackage(ExcData excData) {
        super(excData);
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