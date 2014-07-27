package exceptionquiz.question;

import exceptionquiz.ExcData;

/**
 * Абстрактный суперкласс для вопросов, требующих ввода имени пакета и класса.
 */
abstract class ClassNameAbstractQuestion extends AbstractQuestion {

    ClassNameAbstractQuestion(ExcData excData) {
        super(excData.getExceptionClass());
    }

    @Override
    public String getPrompt() {
        return "Package and class name:";
    }
}