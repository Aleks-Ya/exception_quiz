package exceptionquiz.answer;

import exceptionquiz.Answer;

/**
 * Ответ: название пакета.
 */
public class PackageNameAnswer extends AbstractAnswer {

    public PackageNameAnswer(Class clazz) {
        variants.add(clazz.getPackage().getName());
        ignoreCase = false;
    }
}