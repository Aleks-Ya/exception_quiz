package exceptionquiz.question;

import exceptionquiz.ExcData;
import exceptionquiz.answer.PackageAndClassNameAnswer;

/**
 * Вопрос.
 * Известно: класс исключения.
 * Вопрос: родительский класс?
 */
public class ParentClass extends ClassNameAbstractQuestion {

    public ParentClass(ExcData excData) {
        super(excData);
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
}