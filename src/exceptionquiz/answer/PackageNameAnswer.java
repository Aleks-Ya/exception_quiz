package exceptionquiz.answer;

import exceptionquiz.Answer;

/**
 * Ответ: название пакета.
 */
public class PackageNameAnswer extends NameAbstractAnswer {

    public PackageNameAnswer(Class clazz) {
        rightAnswer = clazz.getPackage().getName();
    }
}